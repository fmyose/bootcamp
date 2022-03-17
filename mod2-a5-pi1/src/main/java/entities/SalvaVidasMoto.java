package entities;

public class SalvaVidasMoto extends Veiculo  implements Socorrista<Motocicleta> {
    @Override
    public void socorrer(Motocicleta motocicleta) {
        System.out.println("Socorro motocicleta - " + motocicleta.getPlaca());
    }
}
