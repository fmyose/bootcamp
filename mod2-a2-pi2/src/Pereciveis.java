public class Pereciveis extends Produto{

    private int diasParaVencer;

    public Pereciveis(String nome, double preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public String toString() {
        return super.toString() + " Pereciveis{" +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }

    @Override
    public double calcular(int quantidadeDeProdutos) {
        int reducao = 1;
        if (diasParaVencer == 1) {
            reducao = 4;
        }
        else if (diasParaVencer == 2) {
            reducao = 3;
        }
        else if (diasParaVencer == 3) {
            reducao = 2;
        }

        return quantidadeDeProdutos * getPreco() / reducao;
    }
}
