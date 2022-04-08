package com.example.mod6a2pi1.repository;

import com.example.mod6a2pi1.model.Joia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, Long> {
}
