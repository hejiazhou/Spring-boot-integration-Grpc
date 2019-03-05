package com.example.gprcserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.gprcserver.dao")
public class GprcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(GprcServerApplication.class, args);
    }
}
