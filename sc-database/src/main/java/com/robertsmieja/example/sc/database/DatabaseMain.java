package com.robertsmieja.example.sc.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class DatabaseMain {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseMain.class, args);
    }
}
