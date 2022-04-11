package com.example.mod6a3pi4.service;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IService<Actor> {

   @Autowired
    ActorRepository actorRepository;

   @Override
   public List<Actor> findAll() {
       return actorRepository.findAll();
   }

   @Override
   public Actor findById(Long id) {
       return actorRepository.findById(id).orElse(null);
   }

   @Override
   public Actor save(Actor actor) {
       actorRepository.save(actor);
       return actor;
   }

   public List<Actor> actorsWithFavoriteMovie() {
       return actorRepository.findActorsByFavoritemovieIsNotNull();
   }

   public List<Actor> actorsWithRatingGreaterThan(Integer rating) {
       return actorRepository.findActorsByRatingGreaterThan(rating);
   }
}
