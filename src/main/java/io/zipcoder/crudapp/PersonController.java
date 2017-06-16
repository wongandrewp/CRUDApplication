package io.zipcoder.crudapp;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by andrewwong on 6/16/17.
 */
@RestController
public class PersonController {

    private PersonService personService;

    public Collection<Person> getAllPersons(){
        return personService.getAllPersons();
    }
}
