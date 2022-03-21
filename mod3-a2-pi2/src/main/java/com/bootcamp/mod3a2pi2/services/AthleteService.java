package com.bootcamp.mod3a2pi2.services;

import com.bootcamp.mod3a2pi2.models.Athlete;
import com.bootcamp.mod3a2pi2.models.AthleteDTO;
import com.bootcamp.mod3a2pi2.models.Person;
import com.bootcamp.mod3a2pi2.models.Sport;
import com.bootcamp.mod3a2pi2.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteService {

    @Autowired
    PersonService personService;

    @Autowired
    SportService sportService;

    @Autowired
    AthleteRepository athleteRepository;

    public List<AthleteDTO> finSportsPersons() {
        return AthleteDTO.convertToDTO(athleteRepository.getAll());
    }

    public AthleteDTO add(Person person, String sportName) {
        Sport sport = sportService.findSport(sportName);
        Athlete athlete = new Athlete(person, sport);
        athleteRepository.getAll().add(athlete);
        return new AthleteDTO().convertToDTO(athlete);
    }
}
