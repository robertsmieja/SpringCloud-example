package com.robertsmieja.example.sc.database.controller;

import com.robertsmieja.example.sc.database.domain.Person;
import com.robertsmieja.example.sc.database.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Mono<Person> getById(@RequestParam Long id) {
        return repository.findById(id);
    }

}
