public class PraticaExcecoes {

    private int a = 0;
    private int b = 300;

    public PraticaExcecoes() {}

    public void divisao() {

        try {
            if (a == 0)
                throw new IllegalArgumentException();
            int divisao = b/a;

        }
        catch (IllegalArgumentException e) {
            System.out.println("Nao pode ser dividido por zero");
        }
        catch (Exception e) {
            System.out.println("Ocorreu um erro");
        }

    }
}
