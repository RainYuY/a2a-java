package org.a2aproject.sdk.client.config;

import org.a2aproject.sdk.spec.A2AClientException;

/**
 * Strategy provider used by the client to create an {@link AgentInterfaceSelector}.
 * <p>
 * Implementations are discovered through {@link java.util.ServiceLoader}. To add a
 * custom strategy, provide an implementation and list it in
 * {@code META-INF/services/org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategy}.
 */
public interface AgentInterfaceSelectionStrategy {

    /**
     * Get the stable name used by {@link ClientConfig.Builder#setAgentInterfaceSelectionStrategy(String)}.
     *
     * @return the strategy name
     */
    String getName();

    /**
     * Create a selector instance for a client.
     * <p>
     * Strategies that need per-client mutable state should keep that state in the
     * returned selector so each client gets an independent selector instance.
     *
     * @return a selector used by a client instance
     * @throws A2AClientException if the selector cannot be created
     */
    AgentInterfaceSelector createSelector() throws A2AClientException;
}
