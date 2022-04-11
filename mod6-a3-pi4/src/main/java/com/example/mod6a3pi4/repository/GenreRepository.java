package com.example.mod6a3pi4.repository;

import com.example.mod6a3pi4.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
