public class Main {

    public static void main(String args[]) {

        String[] cidades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santigo de Chile", "Lisboa", "Tokio"};

        int[][] tempMinMax = { {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35} };

        int cidadeMenorTemp = 0;
        int cidadeMaiorTemp = 0;
        int menorTemp = Integer.MAX_VALUE;
        int maiorTemp = Integer.MIN_VALUE;

        for (int i = 0; i < tempMinMax.length; i++) {
            if (tempMinMax[i][0] < menorTemp) {
                menorTemp = tempMinMax[i][0];
                cidadeMenorTemp = i;
            }
            if (tempMinMax[i][1] > maiorTemp) {
                maiorTemp = tempMinMax[i][1];
                cidadeMaiorTemp = i;
            }
        }

        System.out.println("Temperatura mais alta: " + cidades[cidadeMaiorTemp]);
        System.out.println("Temperatura mais baixa: " + cidades[cidadeMenorTemp]);

    }
}
