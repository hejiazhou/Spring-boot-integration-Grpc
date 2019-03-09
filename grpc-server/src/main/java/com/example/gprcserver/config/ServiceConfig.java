package com.example.gprcserver.config;

import com.example.gprcserver.server.UserServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Superb
 * @Date: 2019/3/8 0008 17:40
 */
@Configuration
public class ServiceConfig {
    @Bean(initMethod = "start",destroyMethod = "shutdown")
    public UserServer createUserServer(){
        return new UserServer();
    }
}
