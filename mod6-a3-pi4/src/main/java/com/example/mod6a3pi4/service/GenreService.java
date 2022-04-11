package com.example.mod6a3pi4.service;

import com.example.mod6a3pi4.model.Genre;
import com.example.mod6a3pi4.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IService<Genre> {

    @Autowired
    GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre save(Genre genre) {
        genreRepository.save(genre);
        return genre;
    }
}
