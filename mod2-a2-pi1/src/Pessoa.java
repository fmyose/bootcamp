public class Pessoa {

    private String nome;
    private int idade;
    private String id;
    private double peso;
    private double altura;

    public Pessoa() { }

    public Pessoa(String nome, int idade, String id) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
    }

    public Pessoa(String nome, int idade, String id, double peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.id = id;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso/(Math.pow(altura, 2));
        if (imc < 20)
            return -1;
        else if (imc >= 20 && imc <= 25)
            return 0;
        else
            return 1;
    }

    public boolean ehMaiorIdade() {
        return idade >= 18 ? true : false;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", id='" + id + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

}
