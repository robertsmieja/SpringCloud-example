package com.robertsmieja.example.sc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ClientMain {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain.class, args);
    }
}
