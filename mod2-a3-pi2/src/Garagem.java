import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Garagem {
    private String id;
    private List<Veiculo> veiculos;

    public Garagem(String id, List<Veiculo> veiculos) {
        this.id = id;
        this.veiculos = veiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void ordenaListaDeVeiculosPorPreco() {
        veiculos.stream().sorted((x,y) -> x.getPreco().compareTo(y.getPreco()))
        .forEach(System.out::println);
    }

    public void ordenaListaDeVeiculosPorMarca() {
        veiculos.stream().sorted((x,y) -> x.getMarca().compareTo(y.getMarca()))
                .forEach(System.out::println);
    }

    public List<Veiculo> veiculosComValorMaiorIgual(BigDecimal valorMinimo) {
        return veiculos.stream().filter(x -> x.getPreco().compareTo(valorMinimo) != -1)
                .collect(Collectors.toList());
    }

    public List<Veiculo> veiculosComValorMenor(BigDecimal valorMaximo) {
        return veiculos.stream().filter(x -> x.getPreco().compareTo(valorMaximo) == -1)
                .collect(Collectors.toList());
    }

    public void precoMedioDaGaragem() {
        System.out.printf("Media do preço: %.2f\n",
                veiculos.stream().mapToDouble(x -> x.getPreco().doubleValue()).average().getAsDouble()
        );
    }
}
