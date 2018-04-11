package com.robertsmieja.example.sc.client.service;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@ShellComponent
public class DiscoveryService {
    DiscoveryClient discoveryClient;

    @ShellMethod("Get all Eureka Services")
    List<String> getServices() {
        return discoveryClient.getServices();
    }

    @ShellMethod("Get all Eureka instances by ID")
    List<ServiceInstance> getInstancesById(@ShellOption("${spring.application.name}") String id) {
        return discoveryClient.getInstances(id);
    }
}
