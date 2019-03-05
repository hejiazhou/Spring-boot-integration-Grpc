package com.example.gprcserver.dao;

import com.example.gprcserver.pojo.User;

/**
 * @author hejiazhou
 */
public interface UserMapper {

    /**
     * 根据id  获取用户
     * @param userId
     * @return
     */
    User getUser(Integer userId);
}
