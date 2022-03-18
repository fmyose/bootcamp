package com.bootcamp.mod3a2pi1;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Idade {

    public static Integer calculaIdade(String dia, String mes, String ano) {
        Integer idade = null;

        if (dia.isBlank() || mes.isBlank() || ano.isBlank()) {
            return idade;
        }

        String nascimentoString = new StringBuilder()
                .append(dia).append("/")
                .append(mes).append("/")
                .append(ano)
                .toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate nascimento = LocalDate.parse(nascimentoString,formatter);
        LocalDate agora = LocalDate.now();

        Period periodo = Period.between(nascimento, agora);

        return periodo.getYears();
    }
}
