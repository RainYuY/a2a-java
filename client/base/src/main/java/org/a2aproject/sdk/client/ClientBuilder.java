package org.a2aproject.sdk.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.a2aproject.sdk.client.config.ClientConfig;
import org.a2aproject.sdk.client.transport.spi.ClientTransport;
import org.a2aproject.sdk.client.transport.spi.ClientTransportConfig;
import org.a2aproject.sdk.client.transport.spi.ClientTransportConfigBuilder;
import org.a2aproject.sdk.client.transport.spi.ClientTransportProvider;
import org.a2aproject.sdk.client.transport.spi.ClientTransportWrapper;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.AgentCard;
import org.a2aproject.sdk.spec.AgentInterface;
import org.a2aproject.sdk.spec.TransportProtocol;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Builder for creating instances of {@link Client} to communicate with A2A agents.
 * <p>
 * ClientBuilder provides a fluent API for configuring and creating client instances that
 * communicate with A2A agents. It handles transport negotiation, event consumer registration,
 * and client configuration in a type-safe manner.
 * <p>
 * <b>Key responsibilities:</b>
 * <ul>
 *   <li>Transport selection and negotiation between client and server capabilities</li>
 *   <li>Event consumer registration for processing agent responses</li>
 *   <li>Error handler configuration for streaming scenarios</li>
 *   <li>Client behavior configuration (streaming, polling, preferences)</li>
 * </ul>
 * <p>
 * <b>Transport Selection:</b> The builder automatically negotiates the best transport protocol
 * based on the agent's {@link AgentCard} and the client's configured transports. By default,
 * the server's preferred transport (first in {@link AgentCard#supportedInterfaces()}) is used.
 * This can be changed by setting {@link ClientConfig#isUseClientPreference()} to {@code true}.
 * <p>
 * <b>Typical usage pattern:</b>
 * <pre>{@code
 * // 1. Get the agent card
 * AgentCard card = A2A.getAgentCard("http://localhost:9999");
 *
 * // 2. Build client with transport and event consumer
 * Client client = Client.builder(card)
 *     .withTransport(JSONRPCTransport.class, new JSONRPCTransportConfigBuilder())
 *     .addConsumer((event, agentCard) -> {
 *         if (event instanceof MessageEvent me) {
 *             System.out.println("Received: " + me.getMessage().parts());
 *         } else if (event instanceof TaskUpdateEvent tue) {
 *             System.out.println("Task status: " + tue.getTask().status().state());
 *         }
 *     })
 *     .build();
 *
 * // 3. Send messages
 * client.sendMessage(A2A.toUserMessage("Hello agent!"));
 * }</pre>
 * <p>
 * <b>Multiple transports:</b> You can configure multiple transports for fallback:
 * <pre>{@code
 * Client client = Client.builder(card)
 *     .withTransport(GrpcTransport.class, new GrpcTransportConfigBuilder()
 *         .channelFactory(ManagedChannelBuilder::forAddress))
 *     .withTransport(JSONRPCTransport.class, new JSONRPCTransportConfigBuilder())
 *     .clientConfig(new ClientConfig.Builder()
 *         .setUseClientPreference(true)  // Try client's preferred order
 *         .build())
 *     .build();
 * }</pre>
 * <p>
 * <b>Error handling:</b> For streaming scenarios, configure an error handler to process exceptions:
 * <pre>{@code
 * Client client = Client.builder(card)
 *     .withTransport(JSONRPCTransport.class, new JSONRPCTransportConfigBuilder())
 *     .streamingErrorHandler(throwable -> {
 *         System.err.println("Stream error: " + throwable.getMessage());
 *     })
 *     .build();
 * }</pre>
 * <p>
 * <b>Thread safety:</b> ClientBuilder is not thread-safe and should only be used from a single
 * thread during client construction. The resulting {@link Client} instance is thread-safe.
 *
 * @see Client
 * @see ClientConfig
 * @see ClientEvent
 * @see org.a2aproject.sdk.client.transport.spi.ClientTransport
 */
public class ClientBuilder {

    private static final Map<String, ClientTransportProvider<? extends ClientTransport, ? extends ClientTransportConfig<?>>> transportProviderRegistry = new HashMap<>();
    private static final Map<Class<? extends ClientTransport>, String> transportProtocolMapping = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientBuilder.class);

    static {
        ServiceLoader<ClientTransportProvider> loader = ServiceLoader.load(ClientTransportProvider.class);
        for (ClientTransportProvider<?, ?> transport : loader) {
            transportProviderRegistry.put(transport.getTransportProtocol(), transport);
            transportProtocolMapping.put(transport.getTransportProtocolClass(), transport.getTransportProtocol());
        }
    }

    private final AgentCard agentCard;

    private final List<BiConsumer<ClientEvent, AgentCard>> consumers = new ArrayList<>();
    private @Nullable Consumer<Throwable> streamErrorHandler;
    private ClientConfig clientConfig = new ClientConfig.Builder().build();

    private final Map<Class<? extends ClientTransport>, ClientTransportConfig<? extends ClientTransport>> clientTransports = new LinkedHashMap<>();
    private @Nullable AgentInterfaceSelection agentInterfaceSelection;

    /**
     * Package-private constructor used by {@link Client#builder(AgentCard)}.
     *
     * @param agentCard the agent card for the agent this client will communicate with (required)
     */
    ClientBuilder(@NonNull AgentCard agentCard) {
        this.agentCard = agentCard;
    }

    /**
     * Configure a transport protocol using a builder for type-safe configuration.
     * <p>
     * Multiple transports can be configured to support fallback scenarios. The actual transport
     * used is negotiated based on the agent's capabilities and the {@link ClientConfig}.
     * <p>
     * Example:
     * <pre>{@code
     * builder.withTransport(JSONRPCTransport.class,
     *     new JSONRPCTransportConfigBuilder()
     *         .httpClient(customHttpClient)
     *         .addInterceptor(loggingInterceptor));
     * }</pre>
     *
     * @param clazz the transport class to configure
     * @param configBuilder the transport configuration builder
     * @param <T> the transport type
     * @return this builder for method chaining
     */
    public <T extends ClientTransport> ClientBuilder withTransport(Class<T> clazz, ClientTransportConfigBuilder<? extends ClientTransportConfig<T>, ?> configBuilder) {
        return withTransport(clazz, configBuilder.build());
    }

    /**
     * Configure a transport protocol with a pre-built configuration.
     * <p>
     * Multiple transports can be configured to support fallback scenarios. The actual transport
     * used is negotiated based on the agent's capabilities and the {@link ClientConfig}.
     * <p>
     * Example:
     * <pre>{@code
     * JSONRPCTransportConfig config = new JSONRPCTransportConfig(myHttpClient);
     * builder.withTransport(JSONRPCTransport.class, config);
     * }</pre>
     *
     * @param clazz the transport class to configure
     * @param config the transport configuration
     * @param <T> the transport type
     * @return this builder for method chaining
     */
    public <T extends ClientTransport> ClientBuilder withTransport(Class<T> clazz, ClientTransportConfig<T> config) {
        clientTransports.put(clazz, config);
        agentInterfaceSelection = null;

        return this;
    }

    /**
     * Add a single event consumer to process events from the agent.
     * <p>
     * Consumers receive {@link ClientEvent} instances (MessageEvent, TaskEvent, TaskUpdateEvent)
     * along with the agent's {@link AgentCard}. Multiple consumers can be registered and will
     * be invoked in registration order.
     * <p>
     * Example:
     * <pre>{@code
     * builder.addConsumer((event, card) -> {
     *     if (event instanceof MessageEvent me) {
     *         String text = me.getMessage().parts().stream()
     *             .filter(p -> p instanceof TextPart)
     *             .map(p -> ((TextPart) p).text())
     *             .collect(Collectors.joining());
     *         System.out.println("Agent: " + text);
     *     }
     * });
     * }</pre>
     *
     * @param consumer the event consumer to add
     * @return this builder for method chaining
     * @see ClientEvent
     * @see MessageEvent
     * @see TaskEvent
     * @see TaskUpdateEvent
     */
    public ClientBuilder addConsumer(BiConsumer<ClientEvent, AgentCard> consumer) {
        this.consumers.add(consumer);
        return this;
    }

    /**
     * Add multiple event consumers to process events from the agent.
     * <p>
     * Consumers receive {@link ClientEvent} instances and are invoked in the order they
     * appear in the list.
     *
     * @param consumers the list of event consumers to add
     * @return this builder for method chaining
     * @see #addConsumer(BiConsumer)
     */
    public ClientBuilder addConsumers(List<BiConsumer<ClientEvent, AgentCard>> consumers) {
        this.consumers.addAll(consumers);
        return this;
    }

    /**
     * Configure an error handler for streaming scenarios.
     * <p>
     * This handler is invoked when errors occur during streaming event consumption. It's only
     * applicable when the client and agent both support streaming. For non-streaming scenarios,
     * errors are thrown directly as {@link A2AClientException}.
     * <p>
     * Example:
     * <pre>{@code
     * builder.streamingErrorHandler(throwable -> {
     *     if (throwable instanceof A2AClientException e) {
     *         log.error("A2A error: " + e.getMessage(), e);
     *     } else {
     *         log.error("Unexpected error: " + throwable.getMessage(), throwable);
     *     }
     * });
     * }</pre>
     *
     * @param streamErrorHandler the error handler for streaming errors
     * @return this builder for method chaining
     */
    public ClientBuilder streamingErrorHandler(Consumer<Throwable> streamErrorHandler) {
        this.streamErrorHandler = streamErrorHandler;
        return this;
    }

    /**
     * Configure client behavior such as streaming mode, polling, and transport preference.
     * <p>
     * The configuration controls how the client communicates with the agent:
     * <ul>
     *   <li>Streaming vs blocking mode</li>
     *   <li>Polling for updates vs receiving events</li>
     *   <li>Client vs server transport preference</li>
     *   <li>Agent interface selection strategy</li>
     *   <li>Output modes, history length, and metadata</li>
     * </ul>
     * <p>
     * Example:
     * <pre>{@code
     * ClientConfig config = new ClientConfig.Builder()
     *     .setStreaming(true)  // Enable streaming if server supports it
     *     .setUseClientPreference(true)  // Use client's transport order
     *     .setHistoryLength(10)  // Request last 10 messages of context
     *     .build();
     * builder.clientConfig(config);
     * }</pre>
     *
     * @param clientConfig the client configuration
     * @return this builder for method chaining
     * @see ClientConfig
     */
    public ClientBuilder clientConfig(@NonNull ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
        agentInterfaceSelection = null;
        return this;
    }

    /**
     * Build the configured {@link Client} instance.
     * <p>
     * This method performs transport negotiation between the client's configured transports
     * and the agent's {@link AgentCard#supportedInterfaces()}, then selects an endpoint
     * for the negotiated protocol. The selection algorithm:
     * <ol>
     *   <li>If {@link ClientConfig#isUseClientPreference()} is {@code true}, iterate through
     *       client transports in registration order and select the first one the server supports</li>
     *   <li>Otherwise, iterate through server interfaces in preference order (first entry
     *       in {@link AgentCard#supportedInterfaces()}) and select the first one the client supports</li>
     *   <li>If the selected protocol has multiple interfaces, use
     *       {@link ClientConfig#getAgentInterfaceSelectionStrategy()} to select the node</li>
     * </ol>
     * <p>
     * <b>Important:</b> At least one transport must be configured via {@link #withTransport},
     * otherwise this method throws {@link A2AClientException}.
     *
     * @return the configured client instance
     * @throws A2AClientException if no compatible transport is found or if transport configuration is missing
     */
    public Client build() throws A2AClientException {
        if (this.clientConfig == null) {
            this.clientConfig = new ClientConfig.Builder().build();
        }

        ClientTransport clientTransport = buildClientTransport();

        return new Client(agentCard, clientConfig, clientTransport, consumers, streamErrorHandler);
    }

    private ClientTransport buildClientTransport() throws A2AClientException {
        List<AgentInterface> candidateInterfaces = findCandidateAgentInterfaces();
        validateTransportConfiguration(candidateInterfaces.get(0));

        if (AgentInterfaceSelectionStrategyRegistry.isFirstCompatible(
                clientConfig.getAgentInterfaceSelectionStrategy(), clientConfig.getAgentInterfaceSelector())) {
            return createClientTransport(candidateInterfaces.get(0));
        }
        return createRoutingClientTransport(candidateInterfaces);
    }

    private List<AgentInterface> getServerInterfaces() throws A2AClientException {
        List<AgentInterface> serverInterfaces = agentCard.supportedInterfaces();
        if (serverInterfaces == null || serverInterfaces.isEmpty()) {
            throw new A2AClientException("No server interface available in the AgentCard");
        }
        return serverInterfaces;
    }

    private List<String> getClientPreferredTransports() {
        List<String> supportedClientTransports = new ArrayList<>();

        if (clientTransports.isEmpty()) {
            // default to JSONRPC if not specified
            supportedClientTransports.add(TransportProtocol.JSONRPC.asString());
        } else {
            clientTransports.forEach((aClass, clientTransportConfig) -> supportedClientTransports.add(transportProtocolMapping.get(aClass)));
        }
        return supportedClientTransports;
    }

    // Package-private for testing
    AgentInterface findBestClientTransport() throws A2AClientException {
        return findBestClientTransport(null);
    }

    // Package-private for testing
    AgentInterface findBestClientTransport(@Nullable Object request) throws A2AClientException {
        return getOrCreateAgentInterfaceSelection().select("client.select", request);
    }

    private AgentInterfaceSelection createAgentInterfaceSelection(List<AgentInterface> candidateInterfaces)
            throws A2AClientException {
        return new AgentInterfaceSelection(
                agentCard,
                candidateInterfaces,
                AgentInterfaceSelectionStrategyRegistry.createSelector(
                        clientConfig.getAgentInterfaceSelectionStrategy(),
                        clientConfig.getAgentInterfaceSelector()));
    }

    private AgentInterfaceSelection getOrCreateAgentInterfaceSelection() throws A2AClientException {
        if (agentInterfaceSelection == null) {
            agentInterfaceSelection = createAgentInterfaceSelection(findCandidateAgentInterfaces());
        }
        return agentInterfaceSelection;
    }

    private ClientTransport createRoutingClientTransport(List<AgentInterface> candidateInterfaces)
            throws A2AClientException {
        ClientTransport routingTransport = RoutingClientTransport.create(
                createAgentInterfaceSelection(candidateInterfaces),
                this::createRawClientTransport);
        return wrap(routingTransport, getClientTransportConfig(candidateInterfaces.get(0)));
    }

    private List<AgentInterface> findCandidateAgentInterfaces() throws A2AClientException {
        List<AgentInterface> serverInterfaces = getServerInterfaces();
        List<String> clientPreferredTransports = getClientPreferredTransports();
        String selectedProtocolBinding = findSelectedProtocolBinding(serverInterfaces, clientPreferredTransports);

        List<AgentInterface> candidateInterfaces = new ArrayList<>();
        for (AgentInterface iface : serverInterfaces) {
            if (selectedProtocolBinding.equals(iface.protocolBinding())) {
                candidateInterfaces.add(iface);
            }
        }

        if (candidateInterfaces.isEmpty()) {
            throw new A2AClientException("No compatible transport found");
        }
        return candidateInterfaces;
    }

    private String findSelectedProtocolBinding(List<AgentInterface> serverInterfaces, List<String> clientPreferredTransports)
            throws A2AClientException {
        String matchedProtocolBinding = null;
        if (clientConfig.isUseClientPreference()) {
            // Client preference: iterate client transports first, find first server match
            for (String clientPreferredTransport : clientPreferredTransports) {
                if (hasServerInterface(serverInterfaces, clientPreferredTransport)) {
                    matchedProtocolBinding = clientPreferredTransport;
                    break;
                }
            }
        } else {
            // Server preference: iterate server interfaces first, find first client match.
            // Multiple interfaces with the same protocol are preserved for node selection.
            for (AgentInterface iface : serverInterfaces) {
                if (clientPreferredTransports.contains(iface.protocolBinding())) {
                    matchedProtocolBinding = iface.protocolBinding();
                    break;
                }
            }
        }

        if (matchedProtocolBinding == null) {
            throw new A2AClientException("No compatible transport found");
        }
        if (!transportProviderRegistry.containsKey(matchedProtocolBinding)) {
            throw new A2AClientException("No client available for " + matchedProtocolBinding);
        }

        return matchedProtocolBinding;
    }

    private boolean hasServerInterface(List<AgentInterface> serverInterfaces, String protocolBinding) {
        for (AgentInterface iface : serverInterfaces) {
            if (protocolBinding.equals(iface.protocolBinding())) {
                return true;
            }
        }
        return false;
    }

    private ClientTransport createClientTransport(AgentInterface agentInterface) throws A2AClientException {
        return wrap(createRawClientTransport(agentInterface), getClientTransportConfig(agentInterface));
    }

    @SuppressWarnings("unchecked")
    private ClientTransport createRawClientTransport(AgentInterface agentInterface) throws A2AClientException {
        ClientTransportProvider clientTransportProvider = transportProviderRegistry.get(agentInterface.protocolBinding());
        if (clientTransportProvider == null) {
            throw new A2AClientException("No client available for " + agentInterface.protocolBinding());
        }

        return clientTransportProvider.create(getClientTransportConfig(agentInterface), agentCard, agentInterface);
    }

    private void validateTransportConfiguration(AgentInterface agentInterface) throws A2AClientException {
        getClientTransportConfig(agentInterface);
    }

    private ClientTransportConfig<? extends ClientTransport> getClientTransportConfig(AgentInterface agentInterface)
            throws A2AClientException {
        ClientTransportProvider<? extends ClientTransport, ? extends ClientTransportConfig<?>> clientTransportProvider =
                transportProviderRegistry.get(agentInterface.protocolBinding());
        if (clientTransportProvider == null) {
            throw new A2AClientException("No client available for " + agentInterface.protocolBinding());
        }
        Class<? extends ClientTransport> transportProtocolClass = clientTransportProvider.getTransportProtocolClass();
        ClientTransportConfig<? extends ClientTransport> clientTransportConfig = clientTransports.get(transportProtocolClass);
        if (clientTransportConfig == null) {
            throw new A2AClientException("Missing required TransportConfig for " + agentInterface.protocolBinding());
        }
        return clientTransportConfig;
    }

    /**
     * Wraps the transport with all available transport wrappers discovered via ServiceLoader.
     * Wrappers are applied in reverse priority order (lowest priority first) to build a stack
     * where the highest priority wrapper is the outermost layer.
     *
     * @param transport the base transport to wrap
     * @param clientTransportConfig the transport configuration
     * @return the wrapped transport (or original if no wrappers are available/applicable)
     */
    private ClientTransport wrap(ClientTransport transport, ClientTransportConfig<? extends ClientTransport> clientTransportConfig) {
        ServiceLoader<ClientTransportWrapper> wrapperLoader = ServiceLoader.load(ClientTransportWrapper.class);

        // Collect all wrappers, sort by priority, then reverse for stack application
        List<ClientTransportWrapper> wrappers = wrapperLoader.stream().map(Provider::get)
                .sorted()
                .collect(Collectors.toList());

        if (wrappers.isEmpty()) {
            LOGGER.debug("No client transport wrappers found via ServiceLoader");
            return transport;
        } 
        LOGGER.debug(wrappers.size() + " client transport wrappers found via ServiceLoader");

        // Reverse to apply lowest priority first (building stack with highest priority outermost)
        java.util.Collections.reverse(wrappers);

        // Apply wrappers to build stack
        ClientTransport wrapped = transport;
        for (ClientTransportWrapper wrapper : wrappers) {
            try {
                ClientTransport newWrapped = wrapper.wrap(wrapped, clientTransportConfig);
                if (newWrapped != wrapped) {
                    LOGGER.debug("Applied transport wrapper: {} (priority: {})",
                            wrapper.getClass().getName(), wrapper.priority());
                }
                wrapped = newWrapped;
            } catch (Exception e) {
                LOGGER.warn("Failed to apply transport wrapper {}: {}",
                        wrapper.getClass().getName(), e.getMessage(), e);
            }
        }

        return wrapped;
    }
}
