package com.bootcamp.mod3a1pi2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Converter {

    private final Map<String, String> dict = new HashMap<String, String>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put(".-.", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put(".....", "5");
        put("-....", "6");
        put("--..", "7");
        put("---..", "8");
        put("----.", "9");
        put("-----", "0");
        put("..--..", "?");
        put("-.-.--", "!");
        put(".-.-.-", ".");
        put("--..--", ",");
    }};

    @RequestMapping("/convert")
    @ResponseBody
    public String convert(@RequestParam String morse){
        StringBuilder traducao = new StringBuilder();

        List<String> morseWords = Arrays.asList(morse.split("   +"));
        for (String word : morseWords) {
            List<String> morseChars = Arrays.asList(word.split(" +"));
            for (String c : morseChars) {
                String value = dict.get(c);
                traducao.append( value == null ? "**" : value);
            }
            traducao.append(" ");
        }
        return traducao.toString();
    }

}
