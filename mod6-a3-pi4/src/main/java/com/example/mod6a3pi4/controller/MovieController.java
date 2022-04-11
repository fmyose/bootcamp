package com.example.mod6a3pi4.controller;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.model.Movie;
import com.example.mod6a3pi4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("movie/{movieId}/actors")
    public ResponseEntity<List<Actor>> actorsFromMovie(@PathParam("movieId") Long movieId) {
        List<Actor> actors = movieService.findActorsByMovie(movieId);
        return ResponseEntity.ok(actors);
    }
}
