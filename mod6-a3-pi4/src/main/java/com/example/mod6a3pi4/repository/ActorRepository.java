package com.example.mod6a3pi4.repository;

import com.example.mod6a3pi4.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    List<Actor> findActorsByFavoritemovieIsNotNull();

    List<Actor> findActorsByRatingGreaterThan(Integer rating);

}
