package org.a2aproject.sdk.client.config;

import java.util.List;

import org.a2aproject.sdk.spec.AgentCard;
import org.a2aproject.sdk.spec.AgentInterface;
import org.a2aproject.sdk.util.Assert;
import org.jspecify.annotations.Nullable;

/**
 * Context passed to an {@link AgentInterfaceSelector}.
 *
 * @param agentCard the agent card used to create the client
 * @param candidateInterfaces compatible interfaces available for this request
 * @param methodName the logical A2A method being invoked
 * @param request the request object for the method, if available
 * @param affinityKey a task, context, or message identifier suitable for sticky routing
 */
public record AgentInterfaceSelectionContext(
        AgentCard agentCard,
        List<AgentInterface> candidateInterfaces,
        String methodName,
        @Nullable Object request,
        @Nullable String affinityKey) {

    public AgentInterfaceSelectionContext {
        Assert.checkNotNullParam("agentCard", agentCard);
        Assert.checkNotNullParam("candidateInterfaces", candidateInterfaces);
        Assert.checkNotNullParam("methodName", methodName);
        candidateInterfaces = List.copyOf(candidateInterfaces);
    }
}
