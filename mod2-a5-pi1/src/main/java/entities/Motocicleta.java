package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Motocicleta extends Veiculo {
    private static final double peso = 300;
    private static final int rodas = 2;

    public Motocicleta(float velocidade, float aceleracao, float anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, peso, rodas);
    }
}
