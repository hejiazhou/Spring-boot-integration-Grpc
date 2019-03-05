package com.example.gprcserver.pojo;

import java.io.Serializable;

/**
 * @author hejiazhou
 */
public class User implements Serializable {
    Integer userId;
    String userName;
    Integer sex;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
