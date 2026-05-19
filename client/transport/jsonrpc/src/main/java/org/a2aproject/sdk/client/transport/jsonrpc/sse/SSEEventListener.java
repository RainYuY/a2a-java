package org.a2aproject.sdk.client.transport.jsonrpc.sse;

import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.logging.Logger;

import org.a2aproject.sdk.client.http.ServerSentEvent;
import org.a2aproject.sdk.client.transport.spi.sse.AbstractSSEEventListener;
import org.a2aproject.sdk.grpc.StreamResponse;
import org.a2aproject.sdk.grpc.utils.JSONRPCUtils;
import org.a2aproject.sdk.grpc.utils.ProtoUtils;
import org.a2aproject.sdk.jsonrpc.common.json.JsonProcessingException;
import org.a2aproject.sdk.spec.A2AError;
import org.a2aproject.sdk.spec.StreamingEventKind;
import org.jspecify.annotations.Nullable;

/**
 * JSON-RPC transport implementation of SSE event listener.
 * Handles parsing of JSON-RPC formatted messages from SSE streams.
 */
public class SSEEventListener extends AbstractSSEEventListener {

    private static final Logger log = Logger.getLogger(SSEEventListener.class.getName());
    private volatile boolean completed = false;

    public SSEEventListener(Consumer<StreamingEventKind> eventHandler,
            @Nullable Consumer<Throwable> errorHandler) {
        super(eventHandler, errorHandler);
    }

    @Override
    public void onMessage(ServerSentEvent event, @Nullable Future<Void> completableFuture) {
        parseAndHandleMessage(event.data(), completableFuture);
    }

    public void onComplete() {
        // Idempotent: only signal completion once, even if called multiple times
        if (completed) {
            log.fine("SSEEventListener.onComplete() called again - ignoring (already completed)");
            return;
        }
        completed = true;

        // Signal normal stream completion (null error means successful completion)
        log.info("SSEEventListener.onComplete() called - signaling successful stream completion, thread=" + Thread.currentThread().getName());
        if (getErrorHandler() != null) {
            log.info("SSEEventListener.onComplete() calling errorHandler.accept(null)");
            getErrorHandler().accept(null);
            log.info("SSEEventListener.onComplete() errorHandler.accept(null) returned");
        } else {
            log.warning("errorHandler is null, cannot signal completion");
        }
    }

    /**
     * Parses a JSON-RPC message and delegates to the base class for event handling.
     *
     * @param message The raw JSON-RPC message string
     * @param future Optional future for controlling the SSE connection
     */
    private void parseAndHandleMessage(String message, @Nullable Future<Void> future) {
        try {
            log.info("SSEEventListener.parseAndHandleMessage: parsing message (length=" + (message == null ? "null" : message.length()) + "), thread=" + Thread.currentThread().getName());
            StreamResponse response = JSONRPCUtils.parseResponseEvent(message);
            StreamingEventKind event = ProtoUtils.FromProto.streamingEventKind(response);
            log.info("SSEEventListener.parseAndHandleMessage: parsed event type=" + event.getClass().getSimpleName());
            // Delegate to base class for common event handling and auto-close logic
            handleEvent(event, future);
        } catch (A2AError error) {
            log.warning("SSEEventListener.parseAndHandleMessage: A2AError caught: " + error.getMessage());
            if (getErrorHandler() != null) {
                getErrorHandler().accept(error);
            }
        } catch (JsonProcessingException e) {
            log.severe("SSEEventListener.parseAndHandleMessage: JsonProcessingException caught: " + e.getMessage() + ", raw message=" + message);
            throw new RuntimeException(e);
        }
    }

}
