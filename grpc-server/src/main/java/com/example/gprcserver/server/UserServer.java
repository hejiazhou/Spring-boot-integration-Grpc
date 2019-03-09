package com.example.gprcserver.server;

import com.example.gprcserver.common.ServerParameter;
import com.example.gprcserver.server.impl.UserServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author hejiazhou
 *  @modify superb
 */
//@Component
public class UserServer /*implements ApplicationRunner*/ {
    private static final Logger logger = Logger.getLogger(UserServer.class.getName());
    private Server server;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserServer userServer;

    private void start() throws Exception {
        System.out.println(userServer+"===");
        server = ServerBuilder.forPort(ServerParameter.USER_SERVICE_PORT)
                .addService(userService)
                .build()
                .start();
        logger.info("Server started, listening on " + ServerParameter.USER_SERVICE_PORT);
        userServer.blockUntilShutdown();

     /*   Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                UserServer.this.stop();
                System.err.println("*** server shut down");
            }
        });*/
    }

    private void shutdown() {
        if (server != null) {
            logger.info("Server stop, listening on " + ServerParameter.USER_SERVICE_PORT);
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    //@Override
 /*   public void run(ApplicationArguments args) throws Exception {
        userServer.start();
        userServer.blockUntilShutdown();
    }*/
}
