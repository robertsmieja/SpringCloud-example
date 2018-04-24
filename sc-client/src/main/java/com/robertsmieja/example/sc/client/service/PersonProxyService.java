package com.robertsmieja.example.sc.client.service;

import com.robertsmieja.example.sc.client.communicator.DatabaseCommunicator;
import com.robertsmieja.example.sc.client.communicator.DatabaseProxyCommunicator;
import com.robertsmieja.example.sc.client.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@ShellCommandGroup
@ShellComponent
public class PersonProxyService {
    DatabaseProxyCommunicator communicator;

    @ShellMethod("Get all Persons")
    Iterable<Person> proxyGetAll() {
        return communicator.getAll();
    }

    @ShellMethod("Get a Person")
    Person proxyGet(Long id) {
        return communicator.getPerson(id);
    }

//    @ShellMethod("Create a Person")
//    Person create(String firstName, String lastName) {
//        Person person = Person.builder()
//                .firstName(firstName)
//                .lastName(lastName)
//                .build();
//        return create(person);
//    }

    @ShellMethod("Create a Person")
    Person proxyCreate(String firstName, String lastName) {
        Person person = Person.builder()
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return create(person);
    }

    Person create(Person person) {
        return communicator.savePerson(person);
    }

    @ShellMethod("Update a Person")
    Person proxyUpdate(Long id, String firstName, String lastName) {
        Person person = Person.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return update(person);
    }

    Person update(Person person) {
        return communicator.updatePerson(person);
    }

    @ShellMethod("Delete a person")
    void proxyDelete(Long id, String firstName, String lastName) {
        Person person = Person.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        delete(person);
    }

    void delete(Person person) {
        communicator.deletePerson(person);
    }
}
