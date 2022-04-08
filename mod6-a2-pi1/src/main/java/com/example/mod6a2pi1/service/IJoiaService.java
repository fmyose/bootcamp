package com.example.mod6a2pi1.service;

import com.example.mod6a2pi1.model.Joia;
import com.example.mod6a2pi1.model.dto.JoiaDTO;

import java.util.List;

public interface IJoiaService {
    public List<Joia> get();
    public void save(Joia joia);
    public void delete(Long id);
    public Joia find(Long id);
    public Joia update(Long id, JoiaDTO joiaParam);
}
