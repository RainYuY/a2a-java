package org.a2aproject.sdk.client.config;

import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.AgentInterface;

/**
 * Selection hook for choosing an {@link AgentInterface} from compatible candidates.
 */
@FunctionalInterface
public interface AgentInterfaceSelector {

    /**
     * Select an interface for a client request.
     *
     * @param context the selection context
     * @return one of {@link AgentInterfaceSelectionContext#candidateInterfaces()}
     * @throws A2AClientException if selection cannot be completed
     */
    AgentInterface select(AgentInterfaceSelectionContext context) throws A2AClientException;
}
