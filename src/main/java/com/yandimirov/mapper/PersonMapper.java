package com.yandimirov.mapper;

import com.yandimirov.model.Person;

import java.util.List;

public interface PersonMapper {
    List<Person> findAll();
    Person findOne(long id);
    void update(Person person);
    void insert(Person person);
    void delete(long id);
}
