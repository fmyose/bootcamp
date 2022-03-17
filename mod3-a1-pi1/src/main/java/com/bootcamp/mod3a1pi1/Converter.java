package com.bootcamp.mod3a1pi1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class Converter {

    @GetMapping("/toRoman")
    @ResponseBody
    public String convertToRoman(@RequestParam int number) {
        return intToRoman(number);
    }
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return  "testes";
    }

    /**
     *  source: https://iteracao.info/java-conversao-de-decimais-em-romanos/
     */
    public String intToRoman(int number) {
        final int[] DECIMAIS =
                {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] ROMANOS =
                {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < DECIMAIS.length; i++) {
            int parteInteira = number / DECIMAIS[i];
            number -= DECIMAIS[i] * parteInteira;
            resultado.append(String.join("", Collections.nCopies(parteInteira, ROMANOS[i])));
        }
        return resultado.toString();
    }

    public List<Integer> getDigits(int number) {
        List<Integer> digits = new ArrayList<>();

        boolean notZero = true;
        int factor = 10;
        while (notZero) {
            Integer digit = number % factor;
            digits.add(digit);
            number = number - digit;
            factor = factor * 10;
            if (number == 0) {
                notZero = false;
            }
        }
        return digits;
    }
}
