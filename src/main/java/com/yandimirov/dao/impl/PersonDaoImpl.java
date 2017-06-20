package com.yandimirov.dao.impl;

import com.yandimirov.dao.PersonDao;
import com.yandimirov.mapper.PersonMapper;
import com.yandimirov.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SqlSessionFactory sessionFactory;

    private PersonMapper personMapper;

    @Autowired
    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public List<Person> findAll(){
        SqlSession session = sessionFactory.openSession();
        List<Person> persons = personMapper.findAll();
        session.close();
        return persons;
    }

    public Person findOne(long id) {
        SqlSession session = sessionFactory.openSession();
        Person person = personMapper.findOne(id);
        session.close();
        return person;
    }

    public Person update(Person person) {
        SqlSession session = sessionFactory.openSession();
        Person oldPerson = findOne(person.getId());
        if(oldPerson.equals(person)){
            return person;
        }
        personMapper.update(person);
        session.commit();
        session.close();
        return person;
    }

    public Person insert(Person person) {
        SqlSession session = sessionFactory.openSession();
        personMapper.insert(person);
        session.commit();
        session.close();
        return person;
    }

    public void delete(long id) {
        SqlSession session = sessionFactory.openSession();
        personMapper.delete(id);
        session.commit();
        session.close();
    }
}
