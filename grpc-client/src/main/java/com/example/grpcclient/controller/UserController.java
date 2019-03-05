package com.example.grpcclient.controller;

import com.example.grpcclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hejiazhou
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据id 获取用户
     * @param id
     * @return
     */
    @GetMapping("/getUser")
    public String getUser(@RequestParam Integer id) throws InterruptedException {
        String userName = userService.getUser(id);
        return userName;
    }
}
