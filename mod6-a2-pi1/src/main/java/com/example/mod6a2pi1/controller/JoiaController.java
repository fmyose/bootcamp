package com.example.mod6a2pi1.controller;

import com.example.mod6a2pi1.model.Joia;
import com.example.mod6a2pi1.model.dto.JoiaDTO;
import com.example.mod6a2pi1.model.dto.JoiaIdDTO;
import com.example.mod6a2pi1.service.IJoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JoiaController {

    @Autowired
    IJoiaService joiaService;

    @PostMapping("/joia/inserir")
    public ResponseEntity<JoiaIdDTO> insere(@RequestBody JoiaDTO joiaDTO) {
        Joia joia = JoiaDTO.convertToJoia(joiaDTO);
        joiaService.save(joia);

        JoiaIdDTO joiaIdDTO = new JoiaIdDTO(joia.getId());
        return new ResponseEntity<JoiaIdDTO>(joiaIdDTO, HttpStatus.CREATED);
    }

    @GetMapping("/joias")
    public ResponseEntity<List<JoiaDTO>> get() {
        List<JoiaDTO> joias  = JoiaDTO.convertToDTO(joiaService.get());

        return ResponseEntity.ok(joias);
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<JoiaIdDTO> delete(@RequestParam Long id) {
        joiaService.delete(id);

        return ResponseEntity.ok(new JoiaIdDTO(id));
    }

    @PatchMapping("/joia/atualizar")
    public ResponseEntity<JoiaDTO> update(@RequestParam Long id, @RequestBody JoiaDTO joiaParam) {
        Joia joia = joiaService.update(id, joiaParam);
        JoiaDTO joiaDTO = JoiaDTO.convertToDTO(joia);

        return  ResponseEntity.ok(joiaDTO);
    }

}
