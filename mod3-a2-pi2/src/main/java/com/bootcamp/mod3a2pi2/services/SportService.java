package com.bootcamp.mod3a2pi2.services;

import com.bootcamp.mod3a2pi2.models.Sport;
import com.bootcamp.mod3a2pi2.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {

    @Autowired
    SportRepository sportRepository;

    public List<Sport> findSports() {
        return sportRepository.getAll();
    }

    public Sport findSport(String name) {
        return sportRepository.find(name);
    }

}
