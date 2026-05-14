package org.a2aproject.sdk.client.selection;

import java.util.concurrent.ThreadLocalRandom;

import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategies;
import org.a2aproject.sdk.client.config.AgentInterfaceSelectionStrategy;
import org.a2aproject.sdk.client.config.AgentInterfaceSelector;
import org.jspecify.annotations.Nullable;

/**
 * Selects a stable interface for requests with the same affinity key.
 */
public final class StickyAgentInterfaceSelectionStrategy implements AgentInterfaceSelectionStrategy {

    @Override
    public String getName() {
        return AgentInterfaceSelectionStrategies.STICKY;
    }

    @Override
    public AgentInterfaceSelector createSelector() {
        return context -> {
            @Nullable String affinityKey = context.affinityKey();
            int index = affinityKey == null || affinityKey.isBlank()
                    ? ThreadLocalRandom.current().nextInt(context.candidateInterfaces().size())
                    : Math.floorMod(affinityKey.hashCode(), context.candidateInterfaces().size());
            return context.candidateInterfaces().get(index);
        };
    }
}
