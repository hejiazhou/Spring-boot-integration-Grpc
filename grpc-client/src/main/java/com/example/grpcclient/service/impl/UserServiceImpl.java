package com.example.grpcclient.service.impl;

import com.example.grpcclient.proto.UserProto;
import com.example.grpcclient.server.client.UserClient;
import com.example.grpcclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hejiazhou
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserClient userClient;

    /**
     * 根据id 获取用户
     *
     * @param userId
     * @return
     */
    @Override
    public String getUser(Integer userId)  {
        UserProto.User userproto = UserProto.User.newBuilder().setUserId(userId).build();
        UserProto.User user = userClient.blockingStub.getUser(userproto);
        return user.getUserName();
    }
}
