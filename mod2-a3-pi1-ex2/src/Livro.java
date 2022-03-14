public class Livro {
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public Livro(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
