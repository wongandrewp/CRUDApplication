package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by andrewwong on 6/16/17.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
