package com.bootcamp.mod3a2pi2.repository;

import com.bootcamp.mod3a2pi2.models.Athlete;
import com.bootcamp.mod3a2pi2.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AthleteRepository implements MyRepository<Athlete> {

    private static List<Athlete> athletes = new ArrayList<>();

    @Autowired
    PersonRepository personRepository;

    @Autowired
    SportRepository sportRepository;

    @Override
    public Athlete find(String personName) {
        return athletes.stream().filter(athlete -> athlete.getPerson().getName().equals(personName))
                .findFirst().orElse(null);
    }

    @Override
    public List<Athlete> getAll() {
        return athletes;
    }

    // use this method to populate initial List, if you want
    public void initializeAthletes() {
        for (Person person: personRepository.getAll()) {
            athletes.add(new Athlete(person, sportRepository.find(sportRepository.getRandomSport())));
        }
    }

}
