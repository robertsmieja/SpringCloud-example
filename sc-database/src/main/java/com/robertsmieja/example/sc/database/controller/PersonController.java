package com.robertsmieja.example.sc.database.controller;

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
    String hello() { return "Hello"; }

    @GetMapping("/")
    Iterable<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Person> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/")
    Person create(@RequestBody Person person) {
        return repository.save(person);
    }

    @PostMapping("/")
    Person createOrUpdate(@RequestBody Person person) {
        return repository.save(person);
    }

    @DeleteMapping("/")
    void delete(@RequestBody Person person) {
        repository.delete(person);
    }
}
