public class Main {

    public static void main(String args[]) {
        Cachorro  cachorro = new Cachorro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        cachorro.emitirSom();
        gato.emitirSom();
        vaca.emitirSom();


        vaca.comerPasto();
        gato.comerCarne();
        gato.comerAnimal(vaca);
        cachorro.comerCarne();
        cachorro.comerAnimal(gato);
    }
}
