package io.zipcoder.crudapp;

import java.util.Collection;

/**
 * Created by andrewwong on 6/16/17.
 */
public class PersonService {

    private PersonDao personDao;

    public Collection<Person> getAllPersons(){
        return personDao.getAllPersons();
    }
}
