package org.a2aproject.sdk.client.transport.grpc;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.a2aproject.sdk.spec.A2AClientException;
import org.a2aproject.sdk.spec.InvalidParamsError;
import org.a2aproject.sdk.spec.TaskNotFoundError;
import org.a2aproject.sdk.spec.UnsupportedOperationError;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.Test;

/**
 * Tests for GrpcErrorMapper - verifies correct mapping of gRPC status codes to A2A error types.
 */
public class GrpcErrorMapperTest {

    @Test
    public void testTaskNotFoundErrorFromNotFoundStatus() {
        StatusRuntimeException grpcException = Status.NOT_FOUND
                .withDescription("Task task-123 not found")
                .asRuntimeException();

        A2AClientException result = GrpcErrorMapper.mapGrpcError(grpcException);

        assertNotNull(result);
        assertNotNull(result.getCause());
        assertInstanceOf(TaskNotFoundError.class, result.getCause());
    }

    @Test
    public void testUnsupportedOperationErrorFromUnimplementedStatus() {
        StatusRuntimeException grpcException = Status.UNIMPLEMENTED
                .withDescription("Operation not supported")
                .asRuntimeException();

        A2AClientException result = GrpcErrorMapper.mapGrpcError(grpcException);

        assertNotNull(result);
        assertNotNull(result.getCause());
        assertInstanceOf(UnsupportedOperationError.class, result.getCause());
    }

    @Test
    public void testInvalidParamsErrorFromInvalidArgumentStatus() {
        StatusRuntimeException grpcException = Status.INVALID_ARGUMENT
                .withDescription("Invalid parameters provided")
                .asRuntimeException();

        A2AClientException result = GrpcErrorMapper.mapGrpcError(grpcException);

        assertNotNull(result);
        assertNotNull(result.getCause());
        assertInstanceOf(InvalidParamsError.class, result.getCause());
    }

    @Test
    public void testFallbackToStatusCodeMapping() {
        StatusRuntimeException grpcException = Status.NOT_FOUND
                .withDescription("Generic not found error")
                .asRuntimeException();

        A2AClientException result = GrpcErrorMapper.mapGrpcError(grpcException);

        assertNotNull(result);
        assertNotNull(result.getCause());
        assertInstanceOf(TaskNotFoundError.class, result.getCause());
    }

    @Test
    public void testCustomErrorPrefix() {
        StatusRuntimeException grpcException = Status.NOT_FOUND
                .withDescription("not found")
                .asRuntimeException();

        String customPrefix = "Custom Error: ";
        A2AClientException result = GrpcErrorMapper.mapGrpcError(grpcException, customPrefix);

        assertNotNull(result);
        assertTrue(result.getMessage().startsWith(customPrefix));
        assertInstanceOf(TaskNotFoundError.class, result.getCause());
    }
}

