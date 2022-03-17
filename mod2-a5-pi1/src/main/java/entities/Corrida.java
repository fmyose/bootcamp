package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Corrida {
    private double distancia;
    private double premio;
    private String nome;
    private int maxVeiculos;
    private List<Veiculo> veiculos;

    SalvaVidasAuto salvaVidasAuto;
    SalvaVidasMoto salvaVidasMoto;

    public Corrida(double distancia, double premio, String nome, int maxVeiculos, List<Veiculo> veiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nome = nome;
        this.maxVeiculos = maxVeiculos;
        this.veiculos = veiculos;
        this.salvaVidasMoto = new SalvaVidasMoto();
        this.salvaVidasAuto = new SalvaVidasAuto();
    }

    public void addVeiculo(Veiculo veiculo) {
        if (veiculos.size() < maxVeiculos) {
            veiculos.add(veiculo);
            System.out.println("Veiculo adicionado - " + veiculo.getPlaca());
            return;
        }
        System.out.println("Corrida cheia. Veiculo não adicionado - " + veiculo.getPlaca());
    }

    public void delete(Veiculo veiculo) {
        veiculos.remove(veiculo);
        System.out.println("Veiculo removido - " + veiculo.getPlaca());
    }

    public void deleteVeiculoComPlaca(String placa) {
        Veiculo veiculo = veiculos.stream().filter(v -> v.getPlaca().equals(placa))
                .findFirst().orElse(null);
        delete(veiculo);
    }

    public float indiceVeiculo(Veiculo veiculo) {
        return (float) (veiculo.getVelocidade() * (veiculo.getAceleracao()/2)
                        /(veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100)));
    }
    public Veiculo vencedor() {
        float indiceDoVencedor = Float.MIN_VALUE;
        Veiculo veiculoVencedor = null;
        for (Veiculo veiculo : veiculos) {
            float indice = indiceVeiculo(veiculo);
            if (indice > indiceDoVencedor) {
                indiceDoVencedor = indice;
                veiculoVencedor = veiculo;                
            }
        }
        System.out.println("Vencedor: " + veiculoVencedor.getPlaca());
        return veiculoVencedor;
    }

    public void socorrerAuto(String placa) {
        salvaVidasAuto.socorrer((Carro) encontrarVeiculo(placa));
    }

    public void socorrerMoto(String placa) {
        salvaVidasMoto.socorrer((Motocicleta) encontrarVeiculo(placa));
    }

    public Veiculo encontrarVeiculo(String placa) {
        return veiculos.stream().filter(veiculo -> veiculo.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }
}
