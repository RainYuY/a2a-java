package org.a2aproject.sdk.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Provides operations for interacting with agents using the A2A protocol.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.30.1)",
    comments = "Source: a2a.proto")
public final class A2AServiceGrpc {

  private A2AServiceGrpc() {}

  public static final String SERVICE_NAME = "lf.a2a.v1.A2AService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest,
      org.a2aproject.sdk.grpc.SendMessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = org.a2aproject.sdk.grpc.SendMessageRequest.class,
      responseType = org.a2aproject.sdk.grpc.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest,
      org.a2aproject.sdk.grpc.SendMessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest, org.a2aproject.sdk.grpc.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = A2AServiceGrpc.getSendMessageMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getSendMessageMethod = A2AServiceGrpc.getSendMessageMethod) == null) {
          A2AServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.SendMessageRequest, org.a2aproject.sdk.grpc.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.SendMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest,
      org.a2aproject.sdk.grpc.StreamResponse> getSendStreamingMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendStreamingMessage",
      requestType = org.a2aproject.sdk.grpc.SendMessageRequest.class,
      responseType = org.a2aproject.sdk.grpc.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest,
      org.a2aproject.sdk.grpc.StreamResponse> getSendStreamingMessageMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SendMessageRequest, org.a2aproject.sdk.grpc.StreamResponse> getSendStreamingMessageMethod;
    if ((getSendStreamingMessageMethod = A2AServiceGrpc.getSendStreamingMessageMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getSendStreamingMessageMethod = A2AServiceGrpc.getSendStreamingMessageMethod) == null) {
          A2AServiceGrpc.getSendStreamingMessageMethod = getSendStreamingMessageMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.SendMessageRequest, org.a2aproject.sdk.grpc.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendStreamingMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("SendStreamingMessage"))
              .build();
        }
      }
    }
    return getSendStreamingMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskRequest,
      org.a2aproject.sdk.grpc.Task> getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = org.a2aproject.sdk.grpc.GetTaskRequest.class,
      responseType = org.a2aproject.sdk.grpc.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskRequest,
      org.a2aproject.sdk.grpc.Task> getGetTaskMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskRequest, org.a2aproject.sdk.grpc.Task> getGetTaskMethod;
    if ((getGetTaskMethod = A2AServiceGrpc.getGetTaskMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getGetTaskMethod = A2AServiceGrpc.getGetTaskMethod) == null) {
          A2AServiceGrpc.getGetTaskMethod = getGetTaskMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.GetTaskRequest, org.a2aproject.sdk.grpc.Task>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.GetTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.Task.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("GetTask"))
              .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTasksRequest,
      org.a2aproject.sdk.grpc.ListTasksResponse> getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = org.a2aproject.sdk.grpc.ListTasksRequest.class,
      responseType = org.a2aproject.sdk.grpc.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTasksRequest,
      org.a2aproject.sdk.grpc.ListTasksResponse> getListTasksMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTasksRequest, org.a2aproject.sdk.grpc.ListTasksResponse> getListTasksMethod;
    if ((getListTasksMethod = A2AServiceGrpc.getListTasksMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getListTasksMethod = A2AServiceGrpc.getListTasksMethod) == null) {
          A2AServiceGrpc.getListTasksMethod = getListTasksMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.ListTasksRequest, org.a2aproject.sdk.grpc.ListTasksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.ListTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.ListTasksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("ListTasks"))
              .build();
        }
      }
    }
    return getListTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.CancelTaskRequest,
      org.a2aproject.sdk.grpc.Task> getCancelTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelTask",
      requestType = org.a2aproject.sdk.grpc.CancelTaskRequest.class,
      responseType = org.a2aproject.sdk.grpc.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.CancelTaskRequest,
      org.a2aproject.sdk.grpc.Task> getCancelTaskMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.CancelTaskRequest, org.a2aproject.sdk.grpc.Task> getCancelTaskMethod;
    if ((getCancelTaskMethod = A2AServiceGrpc.getCancelTaskMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getCancelTaskMethod = A2AServiceGrpc.getCancelTaskMethod) == null) {
          A2AServiceGrpc.getCancelTaskMethod = getCancelTaskMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.CancelTaskRequest, org.a2aproject.sdk.grpc.Task>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.CancelTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.Task.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("CancelTask"))
              .build();
        }
      }
    }
    return getCancelTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SubscribeToTaskRequest,
      org.a2aproject.sdk.grpc.StreamResponse> getSubscribeToTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeToTask",
      requestType = org.a2aproject.sdk.grpc.SubscribeToTaskRequest.class,
      responseType = org.a2aproject.sdk.grpc.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SubscribeToTaskRequest,
      org.a2aproject.sdk.grpc.StreamResponse> getSubscribeToTaskMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.SubscribeToTaskRequest, org.a2aproject.sdk.grpc.StreamResponse> getSubscribeToTaskMethod;
    if ((getSubscribeToTaskMethod = A2AServiceGrpc.getSubscribeToTaskMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getSubscribeToTaskMethod = A2AServiceGrpc.getSubscribeToTaskMethod) == null) {
          A2AServiceGrpc.getSubscribeToTaskMethod = getSubscribeToTaskMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.SubscribeToTaskRequest, org.a2aproject.sdk.grpc.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeToTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.SubscribeToTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("SubscribeToTask"))
              .build();
        }
      }
    }
    return getSubscribeToTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.TaskPushNotificationConfig,
      org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getCreateTaskPushNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTaskPushNotificationConfig",
      requestType = org.a2aproject.sdk.grpc.TaskPushNotificationConfig.class,
      responseType = org.a2aproject.sdk.grpc.TaskPushNotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.TaskPushNotificationConfig,
      org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getCreateTaskPushNotificationConfigMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.TaskPushNotificationConfig, org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getCreateTaskPushNotificationConfigMethod;
    if ((getCreateTaskPushNotificationConfigMethod = A2AServiceGrpc.getCreateTaskPushNotificationConfigMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getCreateTaskPushNotificationConfigMethod = A2AServiceGrpc.getCreateTaskPushNotificationConfigMethod) == null) {
          A2AServiceGrpc.getCreateTaskPushNotificationConfigMethod = getCreateTaskPushNotificationConfigMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.TaskPushNotificationConfig, org.a2aproject.sdk.grpc.TaskPushNotificationConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTaskPushNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.TaskPushNotificationConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.TaskPushNotificationConfig.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("CreateTaskPushNotificationConfig"))
              .build();
        }
      }
    }
    return getCreateTaskPushNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest,
      org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getGetTaskPushNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTaskPushNotificationConfig",
      requestType = org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest.class,
      responseType = org.a2aproject.sdk.grpc.TaskPushNotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest,
      org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getGetTaskPushNotificationConfigMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest, org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getGetTaskPushNotificationConfigMethod;
    if ((getGetTaskPushNotificationConfigMethod = A2AServiceGrpc.getGetTaskPushNotificationConfigMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getGetTaskPushNotificationConfigMethod = A2AServiceGrpc.getGetTaskPushNotificationConfigMethod) == null) {
          A2AServiceGrpc.getGetTaskPushNotificationConfigMethod = getGetTaskPushNotificationConfigMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest, org.a2aproject.sdk.grpc.TaskPushNotificationConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTaskPushNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.TaskPushNotificationConfig.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("GetTaskPushNotificationConfig"))
              .build();
        }
      }
    }
    return getGetTaskPushNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest,
      org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> getListTaskPushNotificationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTaskPushNotificationConfigs",
      requestType = org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest.class,
      responseType = org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest,
      org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> getListTaskPushNotificationConfigsMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest, org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> getListTaskPushNotificationConfigsMethod;
    if ((getListTaskPushNotificationConfigsMethod = A2AServiceGrpc.getListTaskPushNotificationConfigsMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getListTaskPushNotificationConfigsMethod = A2AServiceGrpc.getListTaskPushNotificationConfigsMethod) == null) {
          A2AServiceGrpc.getListTaskPushNotificationConfigsMethod = getListTaskPushNotificationConfigsMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest, org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTaskPushNotificationConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("ListTaskPushNotificationConfigs"))
              .build();
        }
      }
    }
    return getListTaskPushNotificationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest,
      org.a2aproject.sdk.grpc.AgentCard> getGetExtendedAgentCardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExtendedAgentCard",
      requestType = org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest.class,
      responseType = org.a2aproject.sdk.grpc.AgentCard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest,
      org.a2aproject.sdk.grpc.AgentCard> getGetExtendedAgentCardMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest, org.a2aproject.sdk.grpc.AgentCard> getGetExtendedAgentCardMethod;
    if ((getGetExtendedAgentCardMethod = A2AServiceGrpc.getGetExtendedAgentCardMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getGetExtendedAgentCardMethod = A2AServiceGrpc.getGetExtendedAgentCardMethod) == null) {
          A2AServiceGrpc.getGetExtendedAgentCardMethod = getGetExtendedAgentCardMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest, org.a2aproject.sdk.grpc.AgentCard>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExtendedAgentCard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.AgentCard.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("GetExtendedAgentCard"))
              .build();
        }
      }
    }
    return getGetExtendedAgentCardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest,
      com.google.protobuf.Empty> getDeleteTaskPushNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTaskPushNotificationConfig",
      requestType = org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest,
      com.google.protobuf.Empty> getDeleteTaskPushNotificationConfigMethod() {
    io.grpc.MethodDescriptor<org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest, com.google.protobuf.Empty> getDeleteTaskPushNotificationConfigMethod;
    if ((getDeleteTaskPushNotificationConfigMethod = A2AServiceGrpc.getDeleteTaskPushNotificationConfigMethod) == null) {
      synchronized (A2AServiceGrpc.class) {
        if ((getDeleteTaskPushNotificationConfigMethod = A2AServiceGrpc.getDeleteTaskPushNotificationConfigMethod) == null) {
          A2AServiceGrpc.getDeleteTaskPushNotificationConfigMethod = getDeleteTaskPushNotificationConfigMethod =
              io.grpc.MethodDescriptor.<org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTaskPushNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new A2AServiceMethodDescriptorSupplier("DeleteTaskPushNotificationConfig"))
              .build();
        }
      }
    }
    return getDeleteTaskPushNotificationConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static A2AServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<A2AServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<A2AServiceStub>() {
        @java.lang.Override
        public A2AServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new A2AServiceStub(channel, callOptions);
        }
      };
    return A2AServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static A2AServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<A2AServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<A2AServiceBlockingStub>() {
        @java.lang.Override
        public A2AServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new A2AServiceBlockingStub(channel, callOptions);
        }
      };
    return A2AServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static A2AServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<A2AServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<A2AServiceFutureStub>() {
        @java.lang.Override
        public A2AServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new A2AServiceFutureStub(channel, callOptions);
        }
      };
    return A2AServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Provides operations for interacting with agents using the A2A protocol.
   * </pre>
   */
  public static abstract class A2AServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message to an agent.
     * </pre>
     */
    public void sendMessage(org.a2aproject.sdk.grpc.SendMessageRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.SendMessageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sends a streaming message to an agent, allowing for real-time interaction and status updates.
     * Streaming version of `SendMessage`
     * </pre>
     */
    public void sendStreamingMessage(org.a2aproject.sdk.grpc.SendMessageRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendStreamingMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the latest state of a task.
     * </pre>
     */
    public void getTask(org.a2aproject.sdk.grpc.GetTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists tasks that match the specified filter.
     * </pre>
     */
    public void listTasks(org.a2aproject.sdk.grpc.ListTasksRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTasksResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancels a task in progress.
     * </pre>
     */
    public void cancelTask(org.a2aproject.sdk.grpc.CancelTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Subscribes to task updates for tasks not in a terminal state.
     * Returns `UnsupportedOperationError` if the task is already in a terminal state (completed, failed, canceled, rejected).
     * </pre>
     */
    public void subscribeToTask(org.a2aproject.sdk.grpc.SubscribeToTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeToTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * (-- api-linter: client-libraries::4232::required-fields=disabled
     *     api-linter: core::0133::method-signature=disabled
     *     api-linter: core::0133::request-message-name=disabled
     *     aip.dev/not-precedent: method_signature preserved for backwards compatibility --)
     * Creates a push notification config for a task.
     * </pre>
     */
    public void createTaskPushNotificationConfig(org.a2aproject.sdk.grpc.TaskPushNotificationConfig request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTaskPushNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a push notification config for a task.
     * </pre>
     */
    public void getTaskPushNotificationConfig(org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTaskPushNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a list of push notifications configured for a task.
     * </pre>
     */
    public void listTaskPushNotificationConfigs(org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTaskPushNotificationConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the extended agent card for the authenticated agent.
     * </pre>
     */
    public void getExtendedAgentCard(org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.AgentCard> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExtendedAgentCardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a push notification config for a task.
     * </pre>
     */
    public void deleteTaskPushNotificationConfig(org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTaskPushNotificationConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.SendMessageRequest,
                org.a2aproject.sdk.grpc.SendMessageResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getSendStreamingMessageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.SendMessageRequest,
                org.a2aproject.sdk.grpc.StreamResponse>(
                  this, METHODID_SEND_STREAMING_MESSAGE)))
          .addMethod(
            getGetTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.GetTaskRequest,
                org.a2aproject.sdk.grpc.Task>(
                  this, METHODID_GET_TASK)))
          .addMethod(
            getListTasksMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.ListTasksRequest,
                org.a2aproject.sdk.grpc.ListTasksResponse>(
                  this, METHODID_LIST_TASKS)))
          .addMethod(
            getCancelTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.CancelTaskRequest,
                org.a2aproject.sdk.grpc.Task>(
                  this, METHODID_CANCEL_TASK)))
          .addMethod(
            getSubscribeToTaskMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.SubscribeToTaskRequest,
                org.a2aproject.sdk.grpc.StreamResponse>(
                  this, METHODID_SUBSCRIBE_TO_TASK)))
          .addMethod(
            getCreateTaskPushNotificationConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.TaskPushNotificationConfig,
                org.a2aproject.sdk.grpc.TaskPushNotificationConfig>(
                  this, METHODID_CREATE_TASK_PUSH_NOTIFICATION_CONFIG)))
          .addMethod(
            getGetTaskPushNotificationConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest,
                org.a2aproject.sdk.grpc.TaskPushNotificationConfig>(
                  this, METHODID_GET_TASK_PUSH_NOTIFICATION_CONFIG)))
          .addMethod(
            getListTaskPushNotificationConfigsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest,
                org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse>(
                  this, METHODID_LIST_TASK_PUSH_NOTIFICATION_CONFIGS)))
          .addMethod(
            getGetExtendedAgentCardMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest,
                org.a2aproject.sdk.grpc.AgentCard>(
                  this, METHODID_GET_EXTENDED_AGENT_CARD)))
          .addMethod(
            getDeleteTaskPushNotificationConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_TASK_PUSH_NOTIFICATION_CONFIG)))
          .build();
    }
  }

  /**
   * <pre>
   * Provides operations for interacting with agents using the A2A protocol.
   * </pre>
   */
  public static final class A2AServiceStub extends io.grpc.stub.AbstractAsyncStub<A2AServiceStub> {
    private A2AServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected A2AServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new A2AServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to an agent.
     * </pre>
     */
    public void sendMessage(org.a2aproject.sdk.grpc.SendMessageRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.SendMessageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sends a streaming message to an agent, allowing for real-time interaction and status updates.
     * Streaming version of `SendMessage`
     * </pre>
     */
    public void sendStreamingMessage(org.a2aproject.sdk.grpc.SendMessageRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendStreamingMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the latest state of a task.
     * </pre>
     */
    public void getTask(org.a2aproject.sdk.grpc.GetTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists tasks that match the specified filter.
     * </pre>
     */
    public void listTasks(org.a2aproject.sdk.grpc.ListTasksRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTasksResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancels a task in progress.
     * </pre>
     */
    public void cancelTask(org.a2aproject.sdk.grpc.CancelTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Subscribes to task updates for tasks not in a terminal state.
     * Returns `UnsupportedOperationError` if the task is already in a terminal state (completed, failed, canceled, rejected).
     * </pre>
     */
    public void subscribeToTask(org.a2aproject.sdk.grpc.SubscribeToTaskRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeToTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * (-- api-linter: client-libraries::4232::required-fields=disabled
     *     api-linter: core::0133::method-signature=disabled
     *     api-linter: core::0133::request-message-name=disabled
     *     aip.dev/not-precedent: method_signature preserved for backwards compatibility --)
     * Creates a push notification config for a task.
     * </pre>
     */
    public void createTaskPushNotificationConfig(org.a2aproject.sdk.grpc.TaskPushNotificationConfig request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTaskPushNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a push notification config for a task.
     * </pre>
     */
    public void getTaskPushNotificationConfig(org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTaskPushNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a list of push notifications configured for a task.
     * </pre>
     */
    public void listTaskPushNotificationConfigs(org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTaskPushNotificationConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the extended agent card for the authenticated agent.
     * </pre>
     */
    public void getExtendedAgentCard(org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest request,
        io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.AgentCard> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetExtendedAgentCardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a push notification config for a task.
     * </pre>
     */
    public void deleteTaskPushNotificationConfig(org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTaskPushNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Provides operations for interacting with agents using the A2A protocol.
   * </pre>
   */
  public static final class A2AServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<A2AServiceBlockingStub> {
    private A2AServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected A2AServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new A2AServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to an agent.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.SendMessageResponse sendMessage(org.a2aproject.sdk.grpc.SendMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sends a streaming message to an agent, allowing for real-time interaction and status updates.
     * Streaming version of `SendMessage`
     * </pre>
     */
    public java.util.Iterator<org.a2aproject.sdk.grpc.StreamResponse> sendStreamingMessage(
        org.a2aproject.sdk.grpc.SendMessageRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSendStreamingMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the latest state of a task.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.Task getTask(org.a2aproject.sdk.grpc.GetTaskRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists tasks that match the specified filter.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.ListTasksResponse listTasks(org.a2aproject.sdk.grpc.ListTasksRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancels a task in progress.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.Task cancelTask(org.a2aproject.sdk.grpc.CancelTaskRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Subscribes to task updates for tasks not in a terminal state.
     * Returns `UnsupportedOperationError` if the task is already in a terminal state (completed, failed, canceled, rejected).
     * </pre>
     */
    public java.util.Iterator<org.a2aproject.sdk.grpc.StreamResponse> subscribeToTask(
        org.a2aproject.sdk.grpc.SubscribeToTaskRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeToTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * (-- api-linter: client-libraries::4232::required-fields=disabled
     *     api-linter: core::0133::method-signature=disabled
     *     api-linter: core::0133::request-message-name=disabled
     *     aip.dev/not-precedent: method_signature preserved for backwards compatibility --)
     * Creates a push notification config for a task.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.TaskPushNotificationConfig createTaskPushNotificationConfig(org.a2aproject.sdk.grpc.TaskPushNotificationConfig request) {
      return blockingUnaryCall(
          getChannel(), getCreateTaskPushNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a push notification config for a task.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.TaskPushNotificationConfig getTaskPushNotificationConfig(org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTaskPushNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a list of push notifications configured for a task.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse listTaskPushNotificationConfigs(org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTaskPushNotificationConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the extended agent card for the authenticated agent.
     * </pre>
     */
    public org.a2aproject.sdk.grpc.AgentCard getExtendedAgentCard(org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetExtendedAgentCardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a push notification config for a task.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTaskPushNotificationConfig(org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTaskPushNotificationConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Provides operations for interacting with agents using the A2A protocol.
   * </pre>
   */
  public static final class A2AServiceFutureStub extends io.grpc.stub.AbstractFutureStub<A2AServiceFutureStub> {
    private A2AServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected A2AServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new A2AServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message to an agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.SendMessageResponse> sendMessage(
        org.a2aproject.sdk.grpc.SendMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the latest state of a task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.Task> getTask(
        org.a2aproject.sdk.grpc.GetTaskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists tasks that match the specified filter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.ListTasksResponse> listTasks(
        org.a2aproject.sdk.grpc.ListTasksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancels a task in progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.Task> cancelTask(
        org.a2aproject.sdk.grpc.CancelTaskRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * (-- api-linter: client-libraries::4232::required-fields=disabled
     *     api-linter: core::0133::method-signature=disabled
     *     api-linter: core::0133::request-message-name=disabled
     *     aip.dev/not-precedent: method_signature preserved for backwards compatibility --)
     * Creates a push notification config for a task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> createTaskPushNotificationConfig(
        org.a2aproject.sdk.grpc.TaskPushNotificationConfig request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTaskPushNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a push notification config for a task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.TaskPushNotificationConfig> getTaskPushNotificationConfig(
        org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTaskPushNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a list of push notifications configured for a task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse> listTaskPushNotificationConfigs(
        org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTaskPushNotificationConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the extended agent card for the authenticated agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.a2aproject.sdk.grpc.AgentCard> getExtendedAgentCard(
        org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetExtendedAgentCardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a push notification config for a task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTaskPushNotificationConfig(
        org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTaskPushNotificationConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_SEND_STREAMING_MESSAGE = 1;
  private static final int METHODID_GET_TASK = 2;
  private static final int METHODID_LIST_TASKS = 3;
  private static final int METHODID_CANCEL_TASK = 4;
  private static final int METHODID_SUBSCRIBE_TO_TASK = 5;
  private static final int METHODID_CREATE_TASK_PUSH_NOTIFICATION_CONFIG = 6;
  private static final int METHODID_GET_TASK_PUSH_NOTIFICATION_CONFIG = 7;
  private static final int METHODID_LIST_TASK_PUSH_NOTIFICATION_CONFIGS = 8;
  private static final int METHODID_GET_EXTENDED_AGENT_CARD = 9;
  private static final int METHODID_DELETE_TASK_PUSH_NOTIFICATION_CONFIG = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final A2AServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(A2AServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((org.a2aproject.sdk.grpc.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.SendMessageResponse>) responseObserver);
          break;
        case METHODID_SEND_STREAMING_MESSAGE:
          serviceImpl.sendStreamingMessage((org.a2aproject.sdk.grpc.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse>) responseObserver);
          break;
        case METHODID_GET_TASK:
          serviceImpl.getTask((org.a2aproject.sdk.grpc.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task>) responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks((org.a2aproject.sdk.grpc.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTasksResponse>) responseObserver);
          break;
        case METHODID_CANCEL_TASK:
          serviceImpl.cancelTask((org.a2aproject.sdk.grpc.CancelTaskRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.Task>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_TO_TASK:
          serviceImpl.subscribeToTask((org.a2aproject.sdk.grpc.SubscribeToTaskRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.StreamResponse>) responseObserver);
          break;
        case METHODID_CREATE_TASK_PUSH_NOTIFICATION_CONFIG:
          serviceImpl.createTaskPushNotificationConfig((org.a2aproject.sdk.grpc.TaskPushNotificationConfig) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig>) responseObserver);
          break;
        case METHODID_GET_TASK_PUSH_NOTIFICATION_CONFIG:
          serviceImpl.getTaskPushNotificationConfig((org.a2aproject.sdk.grpc.GetTaskPushNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.TaskPushNotificationConfig>) responseObserver);
          break;
        case METHODID_LIST_TASK_PUSH_NOTIFICATION_CONFIGS:
          serviceImpl.listTaskPushNotificationConfigs((org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.ListTaskPushNotificationConfigsResponse>) responseObserver);
          break;
        case METHODID_GET_EXTENDED_AGENT_CARD:
          serviceImpl.getExtendedAgentCard((org.a2aproject.sdk.grpc.GetExtendedAgentCardRequest) request,
              (io.grpc.stub.StreamObserver<org.a2aproject.sdk.grpc.AgentCard>) responseObserver);
          break;
        case METHODID_DELETE_TASK_PUSH_NOTIFICATION_CONFIG:
          serviceImpl.deleteTaskPushNotificationConfig((org.a2aproject.sdk.grpc.DeleteTaskPushNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class A2AServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    A2AServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.a2aproject.sdk.grpc.A2A.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("A2AService");
    }
  }

  private static final class A2AServiceFileDescriptorSupplier
      extends A2AServiceBaseDescriptorSupplier {
    A2AServiceFileDescriptorSupplier() {}
  }

  private static final class A2AServiceMethodDescriptorSupplier
      extends A2AServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    A2AServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (A2AServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new A2AServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .addMethod(getSendStreamingMessageMethod())
              .addMethod(getGetTaskMethod())
              .addMethod(getListTasksMethod())
              .addMethod(getCancelTaskMethod())
              .addMethod(getSubscribeToTaskMethod())
              .addMethod(getCreateTaskPushNotificationConfigMethod())
              .addMethod(getGetTaskPushNotificationConfigMethod())
              .addMethod(getListTaskPushNotificationConfigsMethod())
              .addMethod(getGetExtendedAgentCardMethod())
              .addMethod(getDeleteTaskPushNotificationConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
