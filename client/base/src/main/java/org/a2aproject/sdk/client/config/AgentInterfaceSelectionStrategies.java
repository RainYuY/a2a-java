package org.a2aproject.sdk.client.config;

/**
 * Built-in agent interface selection strategy names.
 */
public final class AgentInterfaceSelectionStrategies {

    /**
     * Select the first compatible interface in preference order.
     */
    public static final String FIRST_COMPATIBLE = "first-compatible";

    /**
     * Randomly select one compatible interface for each request.
     */
    public static final String RANDOM = "random";

    /**
     * Select a compatible interface by hashing the task or context identifier when present.
     * Requests without an affinity key fall back to random selection.
     */
    public static final String STICKY = "sticky";

    /**
     * Use a selector supplied directly in {@link ClientConfig.Builder#setAgentInterfaceSelector(AgentInterfaceSelector)}.
     */
    public static final String CUSTOM = "custom";

    private AgentInterfaceSelectionStrategies() {}
}
