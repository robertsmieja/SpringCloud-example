package com.robertsmieja.example.sc.client.communicator;

import com.robertsmieja.example.sc.client.model.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("sc-database")
public interface DatabaseCommunicator {

    @GetMapping("/person/")
    Iterable<Person> getAll();

    @GetMapping("/person/{id}")
    Person getPerson(@PathVariable long id);

    @PutMapping("/person/")
    Person savePerson(Person person);

    @PostMapping("/person/")
    Person updatePerson(Person person);

    @DeleteMapping("/person/")
    void deletePerson(Person person);
}
