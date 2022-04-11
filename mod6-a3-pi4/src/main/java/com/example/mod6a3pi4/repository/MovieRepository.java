package com.example.mod6a3pi4.repository;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

   // @Query("select first_name, last_name from Actor where Actor.id in (select id from movie_actor where :id = Actor.id)")
    List<Actor> findMoviesById(Long id);
}

