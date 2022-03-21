package com.bootcamp.mod3a2pi2.controllers;

import com.bootcamp.mod3a2pi2.models.Sport;
import com.bootcamp.mod3a2pi2.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        return new ResponseEntity<>(sportService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSport(@PathVariable String name) {
        Sport sport = sportService.findSport(name);
        if (sport != null) {
            return new ResponseEntity<>("Level: " + sport.getLevel(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Sport not found", HttpStatus.NOT_FOUND);
    }
}
