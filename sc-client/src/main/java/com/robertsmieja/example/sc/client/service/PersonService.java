package com.robertsmieja.example.sc.client.service;

import com.robertsmieja.example.sc.client.communicator.DatabaseCommunicator;
import com.robertsmieja.example.sc.client.model.Person;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellMethod;


public class PersonService {
    DatabaseCommunicator communicator;

    PersonService(){

    }


    @ShellMethod
    Iterable<Person> getAll(){
        return communicator.getAll();
    }

}
