package com.bootcamp.mod3a2pi2.repository;

import com.bootcamp.mod3a2pi2.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository implements MyRepository<Person> {
    private static List<Person> people = new ArrayList<>(
            Arrays.asList(
                    new Person("name1", "surname1", 18),
                    new Person("name2", "surname2", 19),
                    new Person("name3", "surname3", 20),
                    new Person("name4", "surname4", 21),
                    new Person("name5", "surname5", 22)
            )
    );

    public Person findByName(String name) {
        return find(name);
    }

    @Override
    public Person find(String name) {
        return people.stream().filter(person -> person.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<Person> getAll() {
        return people;
    }
}
