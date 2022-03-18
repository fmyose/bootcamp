package com.bootcamp.mod3a2pi1.controllers;

import com.bootcamp.mod3a2pi1.Idade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculaIdade {

    @GetMapping("/calculaIdade")
    public Integer calculaIdade(@RequestParam String dia,
                                @RequestParam String mes,
                                @RequestParam String ano) {

        return Idade.calculaIdade(dia, mes, ano);
    }
}
