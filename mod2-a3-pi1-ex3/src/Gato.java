public class Gato extends Animal implements AnimalCarnivoro {

    @Override
    public void emitirSom() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("gato comeu carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("gato comeu " + animal.getClass().getName());
    }
}
