package com.robertsmieja.example.sc.client.service;

import com.robertsmieja.example.sc.client.communicator.DatabaseCommunicator;
import com.robertsmieja.example.sc.client.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@ShellComponent
public class PersonService {
    DatabaseCommunicator communicator;

    @ShellMethod("Get all Persons")
    Iterable<Person> getAll() {
        return communicator.getAll();
    }

    @ShellMethod("Get a Person")
    Person get(Long id){
        return communicator.getPerson(id);
    }

    @ShellMethod("Create a Person")
    Person create(Person person){
        return communicator.savePerson(person);
    }

    @ShellMethod("Update a Person")
    Person update(Person person){
        return communicator.updatePerson(person);
    }

    @ShellMethod("Delete a person")
    void delete(Person person){
        communicator.deletePerson(person);
    }
}
