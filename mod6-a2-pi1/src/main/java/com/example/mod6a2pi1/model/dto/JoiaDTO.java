package com.example.mod6a2pi1.model.dto;

import com.example.mod6a2pi1.model.Joia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoiaDTO {

    private String material;
    private Double peso;
    private Double quilate;

    public static List<JoiaDTO> convertToDTO(List<Joia> joias) {
        return joias.stream().map(joia -> convertToDTO(joia))
                .collect(Collectors.toList());
    }

    public static JoiaDTO convertToDTO(Joia joia) {
        return new JoiaDTO(joia.getMaterial(), joia.getPeso(), joia.getQuilate());
    }

    public static Joia convertToJoia(JoiaDTO joiaDTO) {
        return new Joia(null, joiaDTO.getMaterial(), joiaDTO.getPeso(), joiaDTO.getQuilate());
    }
}
