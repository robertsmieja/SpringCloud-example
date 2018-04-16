package com.robertsmieja.example.sc.database.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.robertsmieja.example.sc.database.domain.Person;
import com.robertsmieja.example.sc.database.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {
    PersonRepository repository;

    @GetMapping("hello")
    @HystrixCommand
    String hello() { return "Hello"; }

    @GetMapping
    @HystrixCommand
    Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @HystrixCommand
    Optional<Person> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping
    @HystrixCommand
    Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @PostMapping
    @HystrixCommand
    Person createOrUpdate(@RequestBody Person person) {
        return repository.save(person);
    }

    @DeleteMapping
    @HystrixCommand
    void delete(@RequestBody Person person) {
        repository.delete(person);
    }
}
