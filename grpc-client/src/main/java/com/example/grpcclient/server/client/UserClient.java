package com.example.grpcclient.server.client;
import com.example.grpcclient.server.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author hejiazhou
 */
@Component
public class UserClient {
    private static final Logger logger = Logger.getLogger(UserClient.class.getName());
    private static final String host = "127.0.0.1";
    private static final int port = 55500;
    private final ManagedChannel channel;
    public final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public UserClient() {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    /** Construct client for accessing HelloWorld server using the existing channel. */
    UserClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
