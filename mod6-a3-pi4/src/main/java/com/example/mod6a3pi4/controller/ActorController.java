package com.example.mod6a3pi4.controller;

import com.example.mod6a3pi4.model.Actor;
import com.example.mod6a3pi4.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> findAll() {
        List<Actor> actors = actorService.findAll();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("actors/favorite")
    public ResponseEntity<List<Actor>> actorsWithFavoriteMovie() {
        List<Actor> actorsWithFavoriteMovie = actorService.actorsWithFavoriteMovie();
        return ResponseEntity.ok(actorsWithFavoriteMovie);
    }

    @GetMapping("/actors/rating/greater-than")
    public ResponseEntity<List<Actor>> actorsWithRatingGreaterThan(@RequestParam Integer rating) {
        List<Actor> actorsWithRatingGreaterThan = actorService.actorsWithRatingGreaterThan(rating);
        return ResponseEntity.ok(actorsWithRatingGreaterThan);
    }

}
