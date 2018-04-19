package com.robertsmieja.example.sc.database.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.robertsmieja.example.sc.database.domain.Person;
import com.robertsmieja.example.sc.database.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;

import java.util.Optional;
import java.util.function.Supplier;

@RequiredArgsConstructor
@RequestMapping("/person")
@RefreshScope
@RestController
public class PersonController {
    final PersonRepository repository;

    @Value("${sc-database.throwException}")
    boolean throwException = false;

    @Value("${sc-database.errorPercent}")
    long errorPercent = 0;

    @GetMapping("hello")
    @HystrixCommand
    String hello() {
        throwIfIShould();
        return executeOrError(() -> "Hello");
    }

    @GetMapping
    @HystrixCommand
    Iterable<Person> findAll() {
        throwIfIShould();
        return executeOrError(() -> repository.findAll());
    }

    @GetMapping("/{id}")
    @HystrixCommand
    Optional<Person> getById(@PathVariable Long id) {
        throwIfIShould();
        return executeOrError(() -> repository.findById(id));
    }

    @PutMapping
    @HystrixCommand
    Person create(@RequestBody Person person) {
        throwIfIShould();
        return executeOrError(() -> repository.save(person));
    }

    @PostMapping
    @HystrixCommand
    Person createOrUpdate(@RequestBody Person person) {
        throwIfIShould();
        return executeOrError(() -> repository.save(person));
    }

    @DeleteMapping
    @HystrixCommand
    void delete(@RequestBody Person person) {
        throwIfIShould();
        executeOrError(() -> repository.delete(person));
    }

    private void throwIfIShould() {
        if (throwException) {
            throw new ServerErrorException("I was told to throw this", (Throwable) null);
        }
    }

    private void executeOrError(Runnable runnable) {
        Supplier<Void> supplier = () -> {
            runnable.run();
            return null;
        };
        executeOrError(supplier);
    }

    private <T> T executeOrError(Supplier<T> executable) {
        int random = RandomUtils.nextInt(0, 101);
        if (random >= (100 - errorPercent)) {
            throw new ServerErrorException("You weren't lucky", (Throwable) null);
        }
        return executable.get();
    }
}
