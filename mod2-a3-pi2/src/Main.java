import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Veiculo fordFiesta = new Veiculo("Fiesta", "Ford", BigDecimal.valueOf(1000));
        Veiculo fordFocus = new Veiculo("Focus", "Ford", BigDecimal.valueOf(1200));
        Veiculo fordExplorer = new Veiculo("Explorer", "Ford", BigDecimal.valueOf(2500));
        Veiculo fiatUno = new Veiculo("Uno", "Fiat", BigDecimal.valueOf(500));
        Veiculo fiatCronos = new Veiculo("Cronos", "Fiat", BigDecimal.valueOf(1000));
        Veiculo fiatTorino = new Veiculo("Torino", "Fiat", BigDecimal.valueOf(1250));
        Veiculo chevroletAveo = new Veiculo("Aveo", "Chevrolet", BigDecimal.valueOf(1250));
        Veiculo chevroletSpin = new Veiculo("Spin", "Chevrolet", BigDecimal.valueOf(2500));
        Veiculo toyotaCorola = new Veiculo("Corola", "Toyota", BigDecimal.valueOf(1200));
        Veiculo toyotaFortuner = new Veiculo("Fortuner", "Toyota", BigDecimal.valueOf(3000));
        Veiculo renaultLogan = new Veiculo("Logan", "Renault", BigDecimal.valueOf(950));

        List<Veiculo> veiculos = Arrays.asList(
                fordFiesta, fordFocus, fordExplorer,
                fiatUno, fiatCronos, fiatTorino,
                chevroletAveo, chevroletSpin,
                toyotaCorola, toyotaFortuner,
                renaultLogan
        );
        Garagem garagem = new Garagem("1", veiculos);

        garagem.ordenaListaDeVeiculosPorPreco();
        System.out.println("--------");
        garagem.ordenaListaDeVeiculosPorMarca();
        System.out.println("--------");
        List<Veiculo> veiculosAcimaDe1000 = garagem.veiculosComValorMaiorIgual(BigDecimal.valueOf(1000));
        veiculosAcimaDe1000.stream().forEach(System.out::println);
        System.out.println("--------");
        List<Veiculo> veiculosAbaixoDe1000 = garagem.veiculosComValorMenor(BigDecimal.valueOf(1000));
        veiculosAbaixoDe1000.stream().forEach(System.out::println);
        System.out.println("--------");
        garagem.precoMedioDaGaragem();
        System.out.println("--------");

    }
}
