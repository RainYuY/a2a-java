package org.a2aproject.sdk.client.selection;

import java.util.concurrent.ThreadLocalRandom;

import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategies;
import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategy;
import org.a2aproject.sdk.client.config.AgentInterfaceSelector;

/**
 * Randomly selects one compatible agent interface for each request.
 */
public final class RandomAgentInterfaceSelectionStrategy implements AgentInterfaceSelectionStrategy {

    @Override
    public String getName() {
        return AgentInterfaceSelectionStrategies.RANDOM;
    }

    @Override
    public AgentInterfaceSelector createSelector() {
        return context -> context.candidateInterfaces()
                .get(ThreadLocalRandom.current().nextInt(context.candidateInterfaces().size()));
    }
}
