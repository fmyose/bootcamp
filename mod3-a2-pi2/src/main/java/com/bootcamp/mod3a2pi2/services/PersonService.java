package com.bootcamp.mod3a2pi2.services;

import com.bootcamp.mod3a2pi2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

}
