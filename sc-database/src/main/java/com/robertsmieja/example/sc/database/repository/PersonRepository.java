package com.robertsmieja.example.sc.database.repository;

import com.robertsmieja.example.sc.database.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {
    List<Person> findAllByFirstNameAndLastName(String firstName, String lastName);

}
