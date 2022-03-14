import java.util.List;

public class Curriculo implements Documento {

    private String nome;
    private String sobrenome;
    private String telefone;
    private String endereco;

    private List<String> atributos;

    public Curriculo(String nome, String sobrenome, String telefone, String endereco, List<String> atributos) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "Curriculo" +
                "\nnome: " + nome + " " + sobrenome +
                "\ntelefone: " + telefone +
                "\nendereco: " + endereco +
                "\natributos: " + atributos;
    }
}
