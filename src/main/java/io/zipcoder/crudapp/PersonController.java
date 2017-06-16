package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrewwong on 6/16/17.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Person> getAllPersons(){
        List<Person> personList = new ArrayList<>();
        personRepo.findAll().forEach(personList::add);
        return personList;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") int id){
        return personRepo.findOne(id);
    }
//
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePersonById(@PathVariable("id") int id){
        personRepo.delete(id);
    }
//
    @RequestMapping(method = RequestMethod.POST)
    public void postPerson(@RequestBody Person person){
        personRepo.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putPerson(@RequestBody Person person){
        
    }


}
