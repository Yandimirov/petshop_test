package com.yandimirov.dao;

import com.yandimirov.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
    Person findOne(long id);
    Person update(Person person);
    Person insert(Person person);
    void delete(long id);
}
