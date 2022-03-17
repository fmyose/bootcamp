package entities;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Veiculo {
    private float velocidade;
    private float aceleracao;
    private float anguloDeGiro;
    private String placa;
    private double peso;
    private int rodas;


}
