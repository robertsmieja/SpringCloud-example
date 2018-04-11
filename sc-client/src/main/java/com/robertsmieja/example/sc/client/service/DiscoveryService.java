package com.robertsmieja.example.sc.client.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.shared.Applications;
import lombok.AllArgsConstructor;
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

    @ShellMethod("Get all Eureka Applications")
    Applications getApplications() {
        return discoveryClient.getApplications();
    }

    @ShellMethod("Get all Eureka instances by ID")
    List<InstanceInfo> getInstancesById(@ShellOption("{$applicationName}") String id) {
        return discoveryClient.getInstancesById(id);
    }
}
