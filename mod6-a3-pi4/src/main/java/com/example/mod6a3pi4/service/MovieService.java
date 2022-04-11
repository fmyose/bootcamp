package com.example.mod6a3pi4.service;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.model.Movie;
import com.example.mod6a3pi4.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IService<Movie> {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public Movie save(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public List<Actor> findActorsByMovie(Long id) {
       // return movieRepository.findMoviesById(id);
        return null;
    }
}
