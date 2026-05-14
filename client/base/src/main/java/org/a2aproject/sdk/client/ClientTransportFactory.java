package org.a2aproject.sdk.client;

import org.a2aproject.sdk.client.transport.spi.ClientTransport;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.AgentInterface;

@FunctionalInterface
interface ClientTransportFactory {
    ClientTransport create(AgentInterface agentInterface) throws A2AClientException;
}
