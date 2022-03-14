public class Cachorro extends Animal implements AnimalCarnivoro {

    @Override
    public void emitirSom() {
        System.out.println("Auau");
    }

    @Override
    public void comerCarne() {
        System.out.println("cachorro comeu carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("cachorro comeu " + animal.getClass().getName());
    }
}
