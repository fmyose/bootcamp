package com.bootcamp.mod3a2pi2.controllers;

import com.bootcamp.mod3a2pi2.models.Athlete;
import com.bootcamp.mod3a2pi2.models.AthleteDTO;
import com.bootcamp.mod3a2pi2.models.Person;
import com.bootcamp.mod3a2pi2.repository.AthleteRepository;
import com.bootcamp.mod3a2pi2.services.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;

    @Autowired
    AthleteService athleteService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<AthleteDTO>> findSportsPersons() {
        return new ResponseEntity<>(athleteService.finSportsPersons(), HttpStatus.OK);
    }

    @GetMapping("/initialize")
    public ResponseEntity<List<Athlete>> initialize() {
        athleteRepository.initializeAthletes();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/setAthlete/{sportName}")
    public ResponseEntity<AthleteDTO> setAthlete(
            @RequestBody Person person, @PathVariable String sportName) {
        AthleteDTO athleteDTO = athleteService.add(person, sportName);
        return new ResponseEntity<>(athleteDTO, HttpStatus.OK);
    }

}
