package com.robertsmieja.example.sc.database.controller;

import com.robertsmieja.example.sc.database.domain.Person;
import com.robertsmieja.example.sc.database.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController("/person")
public class PersonController {

    PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Mono<Person> getById(@RequestParam Long id) {
        return Mono.justOrEmpty(repository.findById(id));
    }

    @PutMapping
    void create(@RequestParam Person person){
        repository.save(person);
    }

    @PostMapping
    Mono<Person> createOrUpdate(@RequestParam Person person){
        return Mono.justOrEmpty(repository.save(person));
    }

    @DeleteMapping
    Mono<Void> delete(@RequestParam Person person){
        repository.delete(person);
        return Mono.empty();
    }
}
