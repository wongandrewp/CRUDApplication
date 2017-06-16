package io.zipcoder.crudapp;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrewwong on 6/16/17.
 */
@Repository
public class PersonDao {

    private static Map<Integer, Person> people;

    static {
        people = new HashMap<Integer, Person>(){
            {
                put(1, new Person("Tim", 25));
                put(2, new Person("Andy", 30));
            }

        };
    }

    public Collection<Person> getAllPersons(){
        return this.people.values();
    }

    public Person getPersonById(Integer id){
        return this.people.get(id);
    }

    public void deletePersonById(int id) {
        this.people.remove(id);
    }
}
