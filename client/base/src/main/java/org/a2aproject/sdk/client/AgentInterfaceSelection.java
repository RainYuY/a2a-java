package org.a2aproject.sdk.client;

import java.util.List;

import org.a2aproject.sdk.client.config.AgentInterfaceSelectionContext;
import org.a2aproject.sdk.client.config.AgentInterfaceSelector;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.AgentCard;
import org.a2aproject.sdk.spec.AgentInterface;
import org.a2aproject.sdk.util.Assert;
import org.jspecify.annotations.Nullable;

final class AgentInterfaceSelection {
    private final AgentCard agentCard;
    private final List<AgentInterface> candidateInterfaces;
    private final AgentInterfaceSelector selector;

    AgentInterfaceSelection(
            AgentCard agentCard,
            List<AgentInterface> candidateInterfaces,
            AgentInterfaceSelector selector) {
        this.agentCard = Assert.checkNotNullParam("agentCard", agentCard);
        this.candidateInterfaces = List.copyOf(Assert.checkNotNullParam("candidateInterfaces", candidateInterfaces));
        this.selector = Assert.checkNotNullParam("selector", selector);
        if (this.candidateInterfaces.isEmpty()) {
            throw new IllegalArgumentException("candidateInterfaces cannot be empty");
        }
    }

    AgentInterface select(String methodName, @Nullable Object request) throws A2AClientException {
        AgentInterface selectedInterface = selector.select(new AgentInterfaceSelectionContext(
                agentCard, candidateInterfaces, methodName, request, RequestAffinityKey.from(request)));
        if (selectedInterface == null || !candidateInterfaces.contains(selectedInterface)) {
            throw new A2AClientException("AgentInterfaceSelector returned an incompatible AgentInterface");
        }
        return selectedInterface;
    }
}
