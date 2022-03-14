public class Vaca extends Animal implements AnimalHerbivoro {

    @Override
    public void emitirSom() {
        System.out.println("mu");
    }

    @Override
    public void comerPasto() {
        System.out.println("vaca comou pasto");
    }
}
