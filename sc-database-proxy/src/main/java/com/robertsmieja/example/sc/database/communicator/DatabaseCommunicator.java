package com.robertsmieja.example.sc.database.communicator;

import com.robertsmieja.example.sc.database.domain.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient("sc-database")
public interface DatabaseCommunicator {

    @GetMapping("/person/")
    Iterable<Person> findAll();

    @GetMapping("/person/{id}")
    Optional<Person> findById(@PathVariable long id);

    @PutMapping("/person/")
    Person save(Person person);

    @PostMapping("/person/")
    Person update(Person person);

    @DeleteMapping("/person/")
    void delete(Person person);
}
