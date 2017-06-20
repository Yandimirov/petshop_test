package com.yandimirov.service;

import com.yandimirov.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {
    List<Person> findAll();
    Person findOne(long id);
    Person update(Person person);
    Person save(Person person);
    void delete(long id);
}
