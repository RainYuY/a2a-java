package org.a2aproject.sdk.client.transport.grpc;

import org.a2aproject.sdk.common.A2AErrorMessages;
import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.InvalidParamsError;
import org.a2aproject.sdk.spec.TaskNotFoundError;
import org.a2aproject.sdk.spec.UnsupportedOperationError;
import io.grpc.Status;

/**
 * Utility class to map gRPC exceptions to appropriate A2A error types.
 */
public class GrpcErrorMapper {

    public static A2AClientException mapGrpcError(Throwable e) {
        return mapGrpcError(e, "gRPC error: ");
    }

    public static A2AClientException mapGrpcError(Throwable e, String errorPrefix) {
        Status status = Status.fromThrowable(e);
        Status.Code code = status.getCode();
        String message = status.getDescription();

        String desc = message != null ? message : e.getMessage() == null ? "" : e.getMessage();
        return switch (code) {
            case NOT_FOUND -> new A2AClientException(errorPrefix + desc, new TaskNotFoundError());
            case UNIMPLEMENTED -> new A2AClientException(errorPrefix + desc, new UnsupportedOperationError());
            case INVALID_ARGUMENT -> new A2AClientException(errorPrefix + desc, new InvalidParamsError());
            case INTERNAL -> new A2AClientException(errorPrefix + desc, new org.a2aproject.sdk.spec.InternalError(null, desc, null));
            case UNAUTHENTICATED -> new A2AClientException(errorPrefix + A2AErrorMessages.AUTHENTICATION_FAILED);
            case PERMISSION_DENIED -> new A2AClientException(errorPrefix + A2AErrorMessages.AUTHORIZATION_FAILED);
            default -> new A2AClientException(errorPrefix + e.getMessage(), e);
        };
    }
}
