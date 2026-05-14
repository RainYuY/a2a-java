package org.a2aproject.sdk.client;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.a2aproject.sdk.client.transport.spi.ClientTransport;
import org.a2aproject.sdk.client.transport.spi.interceptors.ClientCallContext;
import org.a2aproject.sdk.jsonrpc.common.wrappers.ListTasksResult;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.AgentCard;
import org.a2aproject.sdk.spec.AgentInterface;
import org.a2aproject.sdk.spec.CancelTaskParams;
import org.a2aproject.sdk.spec.DeleteTaskPushNotificationConfigParams;
import org.a2aproject.sdk.spec.EventKind;
import org.a2aproject.sdk.spec.GetExtendedAgentCardParams;
import org.a2aproject.sdk.spec.GetTaskPushNotificationConfigParams;
import org.a2aproject.sdk.spec.ListTaskPushNotificationConfigsParams;
import org.a2aproject.sdk.spec.ListTaskPushNotificationConfigsResult;
import org.a2aproject.sdk.spec.ListTasksParams;
import org.a2aproject.sdk.spec.MessageSendParams;
import org.a2aproject.sdk.spec.StreamingEventKind;
import org.a2aproject.sdk.spec.Task;
import org.a2aproject.sdk.spec.TaskIdParams;
import org.a2aproject.sdk.spec.TaskPushNotificationConfig;
import org.a2aproject.sdk.spec.TaskQueryParams;
import org.a2aproject.sdk.util.Assert;
import org.jspecify.annotations.Nullable;

/**
 * Internal composite transport that selects a concrete protocol transport for each request.
 * <p>
 * Concrete network transports are still created through the regular
 * {@link org.a2aproject.sdk.client.transport.spi.ClientTransportProvider} path. This class
 * only owns request routing and transport caching for a negotiated protocol with multiple
 * compatible agent interfaces.
 */
final class RoutingClientTransport implements ClientTransport {
    private final AgentInterfaceSelection agentInterfaceSelection;
    private final ClientTransportFactory transportFactory;
    private final Map<AgentInterface, ClientTransport> transports = new HashMap<>();

    RoutingClientTransport(AgentInterfaceSelection agentInterfaceSelection, ClientTransportFactory transportFactory) {
        this.agentInterfaceSelection = Assert.checkNotNullParam("agentInterfaceSelection", agentInterfaceSelection);
        this.transportFactory = Assert.checkNotNullParam("transportFactory", transportFactory);
    }

    static ClientTransport create(
            AgentInterfaceSelection agentInterfaceSelection,
            ClientTransportFactory transportFactory) {
        return new RoutingClientTransport(agentInterfaceSelection, transportFactory);
    }

    @Override
    public EventKind sendMessage(MessageSendParams request, @Nullable ClientCallContext context)
            throws A2AClientException {
        return transportFor("message/send", request).sendMessage(request, context);
    }

    @Override
    public void sendMessageStreaming(MessageSendParams request, Consumer<StreamingEventKind> eventConsumer,
            Consumer<Throwable> errorConsumer, @Nullable ClientCallContext context) throws A2AClientException {
        transportFor("message/stream", request).sendMessageStreaming(request, eventConsumer, errorConsumer, context);
    }

    @Override
    public Task getTask(TaskQueryParams request, @Nullable ClientCallContext context) throws A2AClientException {
        return transportFor("tasks/get", request).getTask(request, context);
    }

    @Override
    public Task cancelTask(CancelTaskParams request, @Nullable ClientCallContext context) throws A2AClientException {
        return transportFor("tasks/cancel", request).cancelTask(request, context);
    }

    @Override
    public ListTasksResult listTasks(ListTasksParams request, @Nullable ClientCallContext context)
            throws A2AClientException {
        return transportFor("tasks/list", request).listTasks(request, context);
    }

    @Override
    public TaskPushNotificationConfig createTaskPushNotificationConfiguration(
            TaskPushNotificationConfig request, @Nullable ClientCallContext context) throws A2AClientException {
        return transportFor("tasks/pushNotificationConfig/set", request)
                .createTaskPushNotificationConfiguration(request, context);
    }

    @Override
    public TaskPushNotificationConfig getTaskPushNotificationConfiguration(
            GetTaskPushNotificationConfigParams request, @Nullable ClientCallContext context)
            throws A2AClientException {
        return transportFor("tasks/pushNotificationConfig/get", request)
                .getTaskPushNotificationConfiguration(request, context);
    }

    @Override
    public ListTaskPushNotificationConfigsResult listTaskPushNotificationConfigurations(
            ListTaskPushNotificationConfigsParams request, @Nullable ClientCallContext context)
            throws A2AClientException {
        return transportFor("tasks/pushNotificationConfig/list", request)
                .listTaskPushNotificationConfigurations(request, context);
    }

    @Override
    public void deleteTaskPushNotificationConfigurations(
            DeleteTaskPushNotificationConfigParams request, @Nullable ClientCallContext context)
            throws A2AClientException {
        transportFor("tasks/pushNotificationConfig/delete", request)
                .deleteTaskPushNotificationConfigurations(request, context);
    }

    @Override
    public void subscribeToTask(TaskIdParams request, Consumer<StreamingEventKind> eventConsumer,
            Consumer<Throwable> errorConsumer, @Nullable ClientCallContext context) throws A2AClientException {
        transportFor("tasks/resubscribe", request).subscribeToTask(request, eventConsumer, errorConsumer, context);
    }

    @Override
    public AgentCard getExtendedAgentCard(GetExtendedAgentCardParams params, @Nullable ClientCallContext context)
            throws A2AClientException {
        return transportFor("agent/getAuthenticatedExtendedCard", params).getExtendedAgentCard(params, context);
    }

    @Override
    public void close() {
        synchronized (transports) {
            for (ClientTransport transport : transports.values()) {
                transport.close();
            }
            transports.clear();
        }
    }

    private ClientTransport transportFor(String methodName, @Nullable Object request) throws A2AClientException {
        AgentInterface agentInterface = agentInterfaceSelection.select(methodName, request);
        synchronized (transports) {
            ClientTransport transport = transports.get(agentInterface);
            if (transport == null) {
                transport = transportFactory.create(agentInterface);
                transports.put(agentInterface, transport);
            }
            return transport;
        }
    }
}
