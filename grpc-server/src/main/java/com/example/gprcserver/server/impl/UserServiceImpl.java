package com.example.gprcserver.server.impl;

import com.example.gprcserver.dao.UserMapper;
import com.example.gprcserver.pojo.User;
import com.example.gprcserver.proto.UserProto;
import com.example.gprcserver.server.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author hejiazhou
 */
@Component
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Autowired
    private UserMapper userMapper;
    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void getUser(UserProto.User request, StreamObserver<UserProto.User> responseObserver) {
        int userId = request.getUserId();
        User user = userMapper.getUser(userId);
        UserProto.User userProto = null;
        if(user!=null){
            userProto = UserProto.User.newBuilder()
                    .setUserName(user.getUserName()).build();
        }
        responseObserver.onNext(userProto);
        responseObserver.onCompleted();
    }
}
