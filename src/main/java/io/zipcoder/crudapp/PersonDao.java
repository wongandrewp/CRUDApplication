package io.zipcoder.crudapp;

import java.util.Collection;
import java.util.Map;

/**
 * Created by andrewwong on 6/16/17.
 */
public class PersonDao {

    private static Map<Integer, Person> people;

    public Collection<Person> getAllPersons(){
        return this.people.values();
    }

}
