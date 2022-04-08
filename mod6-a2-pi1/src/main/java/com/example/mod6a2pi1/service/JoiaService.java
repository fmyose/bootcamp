package com.example.mod6a2pi1.service;

import com.example.mod6a2pi1.model.Joia;
import com.example.mod6a2pi1.model.dto.JoiaDTO;
import com.example.mod6a2pi1.repository.JoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoiaService implements IJoiaService {

    @Autowired
    JoiaRepository joiaRepository;

    @Override
    public List<Joia> get() {
        return joiaRepository.findAll();
    }

    @Override
    public void save(Joia joia) {
        joiaRepository.save(joia);
    }

    @Override
    public void delete(Long id) {
        joiaRepository.deleteById(id);
    }

    @Override
    public Joia find(Long id) {
        return joiaRepository.findById(id).orElse(null);
    }

    @Override
    public Joia update(Long id, JoiaDTO joiaNewValues) {
        Joia joia = find(id);
        joia.setMaterial(joiaNewValues.getMaterial());
        joia.setPeso(joiaNewValues.getPeso());
        joia.setQuilate(joiaNewValues.getQuilate());
        save(joia);

        return joia;
    }
}
