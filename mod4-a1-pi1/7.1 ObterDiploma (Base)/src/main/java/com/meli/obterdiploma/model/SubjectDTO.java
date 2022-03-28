package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "O nome do assunto não pode ficar vazio.")
    @Pattern(regexp = "[A-Z][a-zzáàâãéèêíïóôõöúçñ]+", message = "O nome do assunto deve começar com letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    String name;

    @NotNull(message = "A nota de assunto não pode ficar vazia.")
    @DecimalMin(value = "0.0", message = "A nota mínima é 0.0.")
    @DecimalMax(value = "10.0", message = "A nota máxima é 10.0.")
    Double score;
}
