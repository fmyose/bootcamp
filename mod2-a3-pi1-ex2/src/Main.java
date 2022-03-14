import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String args[]) {

        Curriculo curriculo1 = new Curriculo(
                "nome",
                "sobrenome",
                "99999-9999",
                "Rua um, 1",
                Arrays.asList("attr1", "attr2", "attr3"));

        System.out.println("----------------");
        Documento.imprime(curriculo1.toString());

        Livro livro1  = new Livro(
                50,
                "Autor",
                "Titulo",
                "Genero"
        );
        System.out.println("----------------");
        Documento.imprime(livro1.toString());

        Relatorio relatorio1 = new Relatorio(
                30,
                3,
                "Autor",
                "Revisor"
        );
        System.out.println("----------------");

        Documento.imprime(relatorio1.toString());
    }
}
