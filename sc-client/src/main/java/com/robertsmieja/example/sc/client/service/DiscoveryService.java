package com.robertsmieja.example.sc.client.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@ShellComponent
public class DiscoveryService {
    @Value("${spring.application.name}")
    static String applicationName;

    DiscoveryClient discoveryClient;
    ObjectMapper objectMapper;

    @ShellMethod("Get all Eureka Services")
    List<String> getServices() {
        return discoveryClient.getServices();
    }

    @ShellMethod("Get all Eureka instances by ID")
    List<String> getInstancesById(@ShellOption(defaultValue = "sc-client") String id) {
        return discoveryClient.getInstances(id).stream()
                .map(this::serviceInstanceToString)
                .collect(Collectors.toList());
    }

    @SneakyThrows(JsonProcessingException.class)
    private String serviceInstanceToString(ServiceInstance serviceInstance){
        return "ServiceInstance=" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(serviceInstance);
    }
}
