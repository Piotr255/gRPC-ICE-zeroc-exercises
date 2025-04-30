package pl.edu.agh;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.exercise.events.EventsGrpc;
import io.grpc.exercise.events.NewsPackage;
import io.grpc.exercise.events.Topics;
import io.grpc.exercise.events.UserId;
import io.grpc.exercise.events.UserInfo;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



public class EventsClient {
    private final ManagedChannel channel;
    private final EventsGrpc.EventsBlockingStub blockingStub;
    private final EventsGrpc.EventsStub asyncStub;
    private static final Logger logger = Logger.getLogger(EventsClient.class.getName());
    private String name;
    private String id;
    private Scanner scanner = new Scanner(System.in);
    public void setName(String name){
        this.name = name;
    }
    public static void main(String[] args) throws InterruptedException {
        EventsClient eventsClient = new EventsClient("localhost", 50051);
        eventsClient.setName(args[0]);
        eventsClient.start();


    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public EventsClient(String remoteHost, int remotePort) {
        channel = ManagedChannelBuilder.forAddress(remoteHost, remotePort)
                .usePlaintext()
                .keepAliveTime(1, TimeUnit.SECONDS)
                .keepAliveTimeout(1, TimeUnit.SECONDS)
                .keepAliveWithoutCalls(true)
                .enableRetry()
                .maxRetryAttempts(5)
                .build();
        blockingStub = EventsGrpc.newBlockingStub(channel);
        asyncStub = EventsGrpc.newStub(channel);
    }

    public void start() throws InterruptedException {
        try {
        Topics topics = getTopics(name);

        String line;
        System.out.println("Give topics you like: ");
        List<String> topicsList = new ArrayList<>();
        while(true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            topicsList.add(input);
        }
        id = topics.getId();
        Topics topicsAnswer = Topics.newBuilder().setId(id).addAllTopics(topicsList).build();
        blockingStub.subscribeTopics(topicsAnswer);
        Thread newsThread = new Thread(this::getNews);
        newsThread.start();
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("end")) {
                UserId userId = UserId.newBuilder().setId(id).build();
                blockingStub.endService(userId);
                break;
            }
            if (input.equals("add")) {
                List<String> addList = new ArrayList<>();
                while (true) {
                    input = scanner.nextLine();
                    if (input.equals("end")) {
                        break;
                    }
                    if(!input.isEmpty()) {
                        addList.add(input);
                    }
                }
                if(!addList.isEmpty()) {
                    Topics topicsAdd = Topics.newBuilder().setId(id).addAllTopics(addList).build();
                    blockingStub.subscribeTopics(topicsAdd);
                }

            }
            if (input.equals("remove")) {
                List<String> removeList = new ArrayList<>();
                while (true) {
                    input = scanner.nextLine();
                    if (input.equals("end")) {
                        break;
                    }
                    if(!input.isEmpty()) {
                        removeList.add(input);
                    }
                }
                if(!removeList.isEmpty()) {
                    Topics topicsRemove = Topics.newBuilder().setId(id).addAllTopics(removeList).build();
                    blockingStub.unsubscribe(topicsRemove);
                }

            }
        }} catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        shutdown();
        scanner.close();
    }

    private Topics getTopics(String name) throws InterruptedException {
        UserInfo userInfo = UserInfo.newBuilder().setName(name).build();
        boolean intializeProblem = false;
        do {
        try {
            String newName;
            if (intializeProblem) {
                System.out.println("Give new name:");
                 newName = scanner.nextLine();
                userInfo = UserInfo.newBuilder().setName(newName).build();
            }
            Topics topics = blockingStub.getTopics(userInfo);
            System.out.printf(String.valueOf(topics));
            intializeProblem = false;
            return topics;
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            intializeProblem = true;
        }
        } while(intializeProblem);
        return null;
    }
    private void getNews() {
    final CountDownLatch finishLatch = new CountDownLatch(1);
    StreamObserver<NewsPackage> streamObserver = new StreamObserver<>() {
        @Override
        public void onNext(NewsPackage newsPackage) {
            System.out.println(newsPackage);
        }

        @Override
        public void onError(Throwable throwable) {
            logger.log(Level.WARNING, "RPC failed: {0}", throwable);
            finishLatch.countDown();
        }

        @Override
        public void onCompleted() {
            logger.info("Finished gettingNews");
            finishLatch.countDown();
        }
    };
    UserId request = UserId.newBuilder().setId(id).build();
    try {
        asyncStub.getNews(request, streamObserver);
        finishLatch.await();
    } catch (StatusRuntimeException e) {
        logger.log(Level.WARNING,"RPC failed: {0}", e.getStatus());
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    }
}
