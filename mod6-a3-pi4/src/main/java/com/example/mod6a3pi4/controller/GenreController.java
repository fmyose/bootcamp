package com.example.mod6a3pi4.controller;

import com.example.mod6a3pi4.model.Genre;
import com.example.mod6a3pi4.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> findAll() {
        List<Genre> genres = genreService.findAll();
        return ResponseEntity.ok(genres);
    }

    @PostMapping("genre")
    public ResponseEntity<Genre> save(@RequestParam Genre genre) {
        genreService.save(genre);
        return new ResponseEntity<>(genre, HttpStatus.CREATED);
    }

}
