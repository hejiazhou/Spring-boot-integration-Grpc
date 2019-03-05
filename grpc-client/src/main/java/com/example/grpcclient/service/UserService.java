package com.example.grpcclient.service;

/**
 * @author hejiazhou
 */
public interface UserService {

    /**
     * 根据id 获取用户
     * @param userId
     * @return
     */
    String getUser(Integer userId) throws InterruptedException;
}
