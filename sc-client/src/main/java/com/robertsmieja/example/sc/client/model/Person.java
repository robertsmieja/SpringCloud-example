package com.robertsmieja.example.sc.client.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    long id;
    String firstName;
    String lastName;
}
