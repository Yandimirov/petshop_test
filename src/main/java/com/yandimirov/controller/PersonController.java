package com.yandimirov.controller;

import com.yandimirov.model.Person;
import com.yandimirov.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersons(){
        return personService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Person getPerson(@PathVariable long id){
        return personService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Person savePerson(@RequestBody Person person){
        return personService.save(person);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public @ResponseBody Person updatePerson(@RequestBody Person person){
        return personService.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable long id){
        personService.delete(id);
    }

}
