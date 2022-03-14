public class Main {

    public static void main(String args[]) {

        Pessoa pessoaP0 = new Pessoa();
        Pessoa pessoaP1 = new Pessoa("Felipe", 100, "111.222.333-44");
        Pessoa pessoaP2 = new Pessoa("Felipe", 100, "111.222.333-44", 65, 1.67);

        int nivelDoPesoP2 = pessoaP2.calcularIMC();
        boolean maioridadeP2 = pessoaP2.ehMaiorIdade();

        System.out.println("Nível de peso: " + resultadoIMC(nivelDoPesoP2));
        System.out.println("Maioridade: " + maioridadeP2);
        System.out.println(pessoaP2.toString());
    }


    public static String resultadoIMC(int nivelDoPeso) {
        if (nivelDoPeso == -1) {
            return "Abaixo do peso";
        }
        else if (nivelDoPeso == 0) {
            return "Peso Saudável";
        }
        else {
            return "Sobrepeso";
        }
    }

}
