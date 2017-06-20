package com.yandimirov.service.impl;

import com.yandimirov.dao.PersonDao;
import com.yandimirov.model.Person;
import com.yandimirov.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    public List<Person> findAll(){
        return personDao.findAll();
    }

    public Person findOne(long id) {
        return personDao.findOne(id);
    }

    public Person update(Person person) {
        return personDao.update(person);
    }

    public Person save(Person person) {
        return personDao.insert(person);
    }

    public void delete(long id) {
        personDao.delete(id);
    }
}
