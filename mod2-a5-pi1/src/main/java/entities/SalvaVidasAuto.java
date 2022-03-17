package entities;

public class SalvaVidasAuto extends Veiculo implements Socorrista<Carro> {
    @Override
    public void socorrer(Carro carro) {
        System.out.println("Socorro carro - " + carro.getPlaca());
    }
}
