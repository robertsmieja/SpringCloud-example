package com.robertsmieja.example.sc.database.repository;

import com.robertsmieja.example.sc.database.domain.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {
}
