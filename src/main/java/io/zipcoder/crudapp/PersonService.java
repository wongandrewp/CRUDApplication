package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by andrewwong on 6/16/17.
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Collection<Person> getAllPersons(){
        return this.personDao.getAllPersons();
    }

    public Person getPersonById(int id){
        return this.personDao.getPersonById(id);
    }

    public void removePersonById(int id) {
        this.personDao.deletePersonById(id);
    }
}
