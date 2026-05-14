package org.a2aproject.sdk.client.selection;

import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategies;
import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategy;
import org.a2aproject.sdk.client.config.AgentInterfaceSelector;

/**
 * Selects the first compatible agent interface.
 */
public final class FirstCompatibleAgentInterfaceSelectionStrategy implements AgentInterfaceSelectionStrategy {

    @Override
    public String getName() {
        return AgentInterfaceSelectionStrategies.FIRST_COMPATIBLE;
    }

    @Override
    public AgentInterfaceSelector createSelector() {
        return context -> context.candidateInterfaces().get(0);
    }
}
