import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    List<Produto> produtos = new ArrayList<>();


    public void executar() {

        NaoPereciveis televisao = new NaoPereciveis("tv", 1000, "eletronico");
        NaoPereciveis fita = new NaoPereciveis("fita", 50, "eletronico");
        NaoPereciveis dvd = new NaoPereciveis("dvd", 200, "eletronico");
        NaoPereciveis computador = new NaoPereciveis("computador", 1000, "eletronico");
        NaoPereciveis celular = new NaoPereciveis("celular", 300, "eletronico");

        Pereciveis banana = new Pereciveis("banana", 2, 7);
        Pereciveis maca = new Pereciveis("maça", 2, 5);
        Pereciveis bala = new Pereciveis("bala", 2, 30);
        Pereciveis pao = new Pereciveis("pão", 2, 7);
        Pereciveis sal = new Pereciveis("sal", 2, 1);

        produtos.add(televisao);
        produtos.add(fita);
        produtos.add(dvd);
        produtos.add(computador);
        produtos.add(celular);

        produtos.add(banana);
        produtos.add(maca);
        produtos.add(bala);
        produtos.add(pao);
        produtos.add(sal);

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }
}
