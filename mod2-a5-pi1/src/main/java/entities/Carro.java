package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Carro extends Veiculo {
    private static final double peso = 1000;
    private static final int rodas = 4;

    public Carro(float velocidade, float aceleracao, float anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, peso, rodas);
    }
}
