package org.a2aproject.sdk.client;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategies;
import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategy;
import org.a2aproject.sdk.client.config.AgentInterfaceSelector;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.util.Assert;
import org.jspecify.annotations.Nullable;

final class AgentInterfaceSelectionStrategyRegistry {
    private static final Map<String, AgentInterfaceSelectionStrategy> STRATEGIES = loadStrategies();

    private AgentInterfaceSelectionStrategyRegistry() {}

    static boolean isFirstCompatible(String strategyName, @Nullable AgentInterfaceSelector selector) {
        return selector == null && AgentInterfaceSelectionStrategies.FIRST_COMPATIBLE.equals(strategyName);
    }

    static AgentInterfaceSelector createSelector(String strategyName, @Nullable AgentInterfaceSelector configuredSelector)
            throws A2AClientException {
        if (configuredSelector != null) {
            return configuredSelector;
        }

        AgentInterfaceSelectionStrategy strategy = STRATEGIES.get(strategyName);
        if (strategy == null) {
            throw new A2AClientException("No AgentInterfaceSelectionStrategy available for " + strategyName);
        }

        AgentInterfaceSelector selector = strategy.createSelector();
        if (selector == null) {
            throw new A2AClientException("AgentInterfaceSelectionStrategy returned a null selector: " + strategyName);
        }
        return selector;
    }

    private static Map<String, AgentInterfaceSelectionStrategy> loadStrategies() {
        Map<String, AgentInterfaceSelectionStrategy> strategies = new HashMap<>();
        ServiceLoader<AgentInterfaceSelectionStrategy> loader = ServiceLoader.load(AgentInterfaceSelectionStrategy.class);
        for (AgentInterfaceSelectionStrategy strategy : loader) {
            String strategyName = Assert.checkNotNullParam("strategyName", strategy.getName());
            if (strategyName.isBlank()) {
                throw new IllegalStateException("AgentInterfaceSelectionStrategy name cannot be blank");
            }
            AgentInterfaceSelectionStrategy previous = strategies.putIfAbsent(strategyName, strategy);
            if (previous != null) {
                throw new IllegalStateException("Duplicate AgentInterfaceSelectionStrategy name: " + strategyName);
            }
        }
        return Map.copyOf(strategies);
    }
}
