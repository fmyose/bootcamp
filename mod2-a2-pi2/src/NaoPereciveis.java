public class NaoPereciveis extends Produto {

    private String tipo;

    public NaoPereciveis(String nome, double preco, String tipo) {
        super(nome, preco);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " NaoPereciveis{" +
                "tipo='" + tipo + '\'' +
                '}';
    }

}
