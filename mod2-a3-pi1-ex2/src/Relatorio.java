public class Relatorio {
    private int comprimento;
    private int numPaginas;
    private String autor;
    private String revisor;

    public Relatorio(int comprimento, int numPaginas, String autor, String revisor) {
        this.comprimento = comprimento;
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "comprimento=" + comprimento +
                ", numPaginas=" + numPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
