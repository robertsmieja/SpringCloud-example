package com.robertsmieja.example.sc.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DatabaseMain {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseMain.class, args);
    }
}
