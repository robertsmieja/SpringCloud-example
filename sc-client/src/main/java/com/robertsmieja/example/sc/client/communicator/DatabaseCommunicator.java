package com.robertsmieja.example.sc.client.communicator;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("database")
public class DatabaseCommunicator {
}
