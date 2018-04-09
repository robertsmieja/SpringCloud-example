package com.robertsmieja.example.sc.database.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Id
    long id;

    String firstName;
    String lastName;
}
