import entities.Carro;
import entities.Corrida;
import entities.Motocicleta;
import entities.Veiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carro c1 = new Carro(100, 10, 20, "PLACA-C1");
        Carro c2 = new Carro(110, 8, 15, "PLACA-C2");
        Motocicleta m1 = new Motocicleta(110, 8, 15, "PLACA-M1");
        Motocicleta m2 = new Motocicleta(110, 8, 15, "PLACA-M2");

        List<Veiculo> veiculos = new ArrayList<>(Arrays.asList(c1,c2,m1,m2));
        Corrida corrida = new Corrida(10, 10000, "Circuito 1", 5, veiculos);

        Carro c3 = new Carro(110, 8, 15, "PLACA-C3");
        Carro c4 = new Carro(110, 8, 15, "PLACA-C4");
        Motocicleta m3 = new Motocicleta(110, 8, 15, "PLACA-M3");

        corrida.addVeiculo(c3);
        corrida.addVeiculo(c4);
        corrida.addVeiculo(m3);

        corrida.delete(c1);
        corrida.deleteVeiculoComPlaca(m1.getPlaca());
        corrida.addVeiculo(c4);
        corrida.addVeiculo(m3);

        corrida.socorrerAuto(c2.getPlaca());
        corrida.socorrerMoto(m3.getPlaca());

        corrida.vencedor();
    }
}
