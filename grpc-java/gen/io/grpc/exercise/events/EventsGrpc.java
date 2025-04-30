package io.grpc.exercise.events;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.71.0)",
    comments = "Source: events.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EventsGrpc {

  private EventsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "events.Events";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.exercise.events.UserInfo,
      io.grpc.exercise.events.Topics> getGetTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopics",
      requestType = io.grpc.exercise.events.UserInfo.class,
      responseType = io.grpc.exercise.events.Topics.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.exercise.events.UserInfo,
      io.grpc.exercise.events.Topics> getGetTopicsMethod() {
    io.grpc.MethodDescriptor<io.grpc.exercise.events.UserInfo, io.grpc.exercise.events.Topics> getGetTopicsMethod;
    if ((getGetTopicsMethod = EventsGrpc.getGetTopicsMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getGetTopicsMethod = EventsGrpc.getGetTopicsMethod) == null) {
          EventsGrpc.getGetTopicsMethod = getGetTopicsMethod =
              io.grpc.MethodDescriptor.<io.grpc.exercise.events.UserInfo, io.grpc.exercise.events.Topics>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.UserInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.Topics.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("GetTopics"))
              .build();
        }
      }
    }
    return getGetTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics,
      com.google.protobuf.Empty> getSubscribeTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubscribeTopics",
      requestType = io.grpc.exercise.events.Topics.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics,
      com.google.protobuf.Empty> getSubscribeTopicsMethod() {
    io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics, com.google.protobuf.Empty> getSubscribeTopicsMethod;
    if ((getSubscribeTopicsMethod = EventsGrpc.getSubscribeTopicsMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getSubscribeTopicsMethod = EventsGrpc.getSubscribeTopicsMethod) == null) {
          EventsGrpc.getSubscribeTopicsMethod = getSubscribeTopicsMethod =
              io.grpc.MethodDescriptor.<io.grpc.exercise.events.Topics, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubscribeTopics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.Topics.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("SubscribeTopics"))
              .build();
        }
      }
    }
    return getSubscribeTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId,
      io.grpc.exercise.events.NewsPackage> getGetNewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNews",
      requestType = io.grpc.exercise.events.UserId.class,
      responseType = io.grpc.exercise.events.NewsPackage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId,
      io.grpc.exercise.events.NewsPackage> getGetNewsMethod() {
    io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId, io.grpc.exercise.events.NewsPackage> getGetNewsMethod;
    if ((getGetNewsMethod = EventsGrpc.getGetNewsMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getGetNewsMethod = EventsGrpc.getGetNewsMethod) == null) {
          EventsGrpc.getGetNewsMethod = getGetNewsMethod =
              io.grpc.MethodDescriptor.<io.grpc.exercise.events.UserId, io.grpc.exercise.events.NewsPackage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.UserId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.NewsPackage.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("GetNews"))
              .build();
        }
      }
    }
    return getGetNewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics,
      com.google.protobuf.Empty> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unsubscribe",
      requestType = io.grpc.exercise.events.Topics.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics,
      com.google.protobuf.Empty> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<io.grpc.exercise.events.Topics, com.google.protobuf.Empty> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = EventsGrpc.getUnsubscribeMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getUnsubscribeMethod = EventsGrpc.getUnsubscribeMethod) == null) {
          EventsGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<io.grpc.exercise.events.Topics, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.Topics.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("Unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId,
      com.google.protobuf.Empty> getEndServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EndService",
      requestType = io.grpc.exercise.events.UserId.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId,
      com.google.protobuf.Empty> getEndServiceMethod() {
    io.grpc.MethodDescriptor<io.grpc.exercise.events.UserId, com.google.protobuf.Empty> getEndServiceMethod;
    if ((getEndServiceMethod = EventsGrpc.getEndServiceMethod) == null) {
      synchronized (EventsGrpc.class) {
        if ((getEndServiceMethod = EventsGrpc.getEndServiceMethod) == null) {
          EventsGrpc.getEndServiceMethod = getEndServiceMethod =
              io.grpc.MethodDescriptor.<io.grpc.exercise.events.UserId, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EndService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.exercise.events.UserId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EventsMethodDescriptorSupplier("EndService"))
              .build();
        }
      }
    }
    return getEndServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsStub>() {
        @java.lang.Override
        public EventsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsStub(channel, callOptions);
        }
      };
    return EventsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static EventsBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsBlockingV2Stub>() {
        @java.lang.Override
        public EventsBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsBlockingV2Stub(channel, callOptions);
        }
      };
    return EventsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsBlockingStub>() {
        @java.lang.Override
        public EventsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsBlockingStub(channel, callOptions);
        }
      };
    return EventsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventsFutureStub>() {
        @java.lang.Override
        public EventsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventsFutureStub(channel, callOptions);
        }
      };
    return EventsFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getTopics(io.grpc.exercise.events.UserInfo request,
        io.grpc.stub.StreamObserver<io.grpc.exercise.events.Topics> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTopicsMethod(), responseObserver);
    }

    /**
     */
    default void subscribeTopics(io.grpc.exercise.events.Topics request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeTopicsMethod(), responseObserver);
    }

    /**
     */
    default void getNews(io.grpc.exercise.events.UserId request,
        io.grpc.stub.StreamObserver<io.grpc.exercise.events.NewsPackage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNewsMethod(), responseObserver);
    }

    /**
     */
    default void unsubscribe(io.grpc.exercise.events.Topics request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    default void endService(io.grpc.exercise.events.UserId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEndServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Events.
   */
  public static abstract class EventsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EventsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Events.
   */
  public static final class EventsStub
      extends io.grpc.stub.AbstractAsyncStub<EventsStub> {
    private EventsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsStub(channel, callOptions);
    }

    /**
     */
    public void getTopics(io.grpc.exercise.events.UserInfo request,
        io.grpc.stub.StreamObserver<io.grpc.exercise.events.Topics> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeTopics(io.grpc.exercise.events.Topics request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getNews(io.grpc.exercise.events.UserId request,
        io.grpc.stub.StreamObserver<io.grpc.exercise.events.NewsPackage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetNewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(io.grpc.exercise.events.Topics request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void endService(io.grpc.exercise.events.UserId request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEndServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Events.
   */
  public static final class EventsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<EventsBlockingV2Stub> {
    private EventsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public io.grpc.exercise.events.Topics getTopics(io.grpc.exercise.events.UserInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty subscribeTopics(io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, io.grpc.exercise.events.NewsPackage>
        getNews(io.grpc.exercise.events.UserId request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getGetNewsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unsubscribe(io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty endService(io.grpc.exercise.events.UserId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEndServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Events.
   */
  public static final class EventsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventsBlockingStub> {
    private EventsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.exercise.events.Topics getTopics(io.grpc.exercise.events.UserInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty subscribeTopics(io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeTopicsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.exercise.events.NewsPackage> getNews(
        io.grpc.exercise.events.UserId request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetNewsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unsubscribe(io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty endService(io.grpc.exercise.events.UserId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEndServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Events.
   */
  public static final class EventsFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventsFutureStub> {
    private EventsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventsFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.exercise.events.Topics> getTopics(
        io.grpc.exercise.events.UserInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTopicsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> subscribeTopics(
        io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeTopicsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unsubscribe(
        io.grpc.exercise.events.Topics request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> endService(
        io.grpc.exercise.events.UserId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEndServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TOPICS = 0;
  private static final int METHODID_SUBSCRIBE_TOPICS = 1;
  private static final int METHODID_GET_NEWS = 2;
  private static final int METHODID_UNSUBSCRIBE = 3;
  private static final int METHODID_END_SERVICE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TOPICS:
          serviceImpl.getTopics((io.grpc.exercise.events.UserInfo) request,
              (io.grpc.stub.StreamObserver<io.grpc.exercise.events.Topics>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_TOPICS:
          serviceImpl.subscribeTopics((io.grpc.exercise.events.Topics) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_NEWS:
          serviceImpl.getNews((io.grpc.exercise.events.UserId) request,
              (io.grpc.stub.StreamObserver<io.grpc.exercise.events.NewsPackage>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((io.grpc.exercise.events.Topics) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_END_SERVICE:
          serviceImpl.endService((io.grpc.exercise.events.UserId) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetTopicsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.exercise.events.UserInfo,
              io.grpc.exercise.events.Topics>(
                service, METHODID_GET_TOPICS)))
        .addMethod(
          getSubscribeTopicsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.exercise.events.Topics,
              com.google.protobuf.Empty>(
                service, METHODID_SUBSCRIBE_TOPICS)))
        .addMethod(
          getGetNewsMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              io.grpc.exercise.events.UserId,
              io.grpc.exercise.events.NewsPackage>(
                service, METHODID_GET_NEWS)))
        .addMethod(
          getUnsubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.exercise.events.Topics,
              com.google.protobuf.Empty>(
                service, METHODID_UNSUBSCRIBE)))
        .addMethod(
          getEndServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.exercise.events.UserId,
              com.google.protobuf.Empty>(
                service, METHODID_END_SERVICE)))
        .build();
  }

  private static abstract class EventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.exercise.events.EventsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Events");
    }
  }

  private static final class EventsFileDescriptorSupplier
      extends EventsBaseDescriptorSupplier {
    EventsFileDescriptorSupplier() {}
  }

  private static final class EventsMethodDescriptorSupplier
      extends EventsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EventsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EventsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventsFileDescriptorSupplier())
              .addMethod(getGetTopicsMethod())
              .addMethod(getSubscribeTopicsMethod())
              .addMethod(getGetNewsMethod())
              .addMethod(getUnsubscribeMethod())
              .addMethod(getEndServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
