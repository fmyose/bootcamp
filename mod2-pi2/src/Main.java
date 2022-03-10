import java.util.*;

public class Main {

    public static List<HashMap<String,Object>> circuitoPequeno = new ArrayList<>();
    public static List<HashMap<String,Object>> circuitoMedio = new ArrayList<>();
    public static List<HashMap<String,Object>> circuitoAvancado = new ArrayList<>();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int escolha = 1;
        while (escolha != 0) {
            System.out.println("1. inscricao");
            System.out.println("2. listar cadastros por categoria");
            System.out.println("3. cancelar inscricao");
            System.out.println("0. sair");
        }

        boolean sucessoNaInscricao = inscricao();


    }

    public static boolean inscricao() {
        HashMap<String, Object> novoParticipante = new HashMap<>();

        System.out.println("Qual categoria? \n1. pequeno\n2. medio\n3.avancado\n");
        int categoriaEscolhida = scanner.nextInt();
        System.out.println("idade: ");
        int idadeParticipante = scanner.nextInt();
        if (categoriaEscolhida == 3 && idadeParticipante < 18) {
            System.out.println("nao permitido");
        }
        else {

            System.out.println("RG: ");
            novoParticipante.put("RG", scanner.next());
            System.out.println("nome: ");
            novoParticipante.put("nome", "Aaa");
            System.out.println("sobrenome: ");
            novoParticipante.put("sobrenome", "Bbb");
            System.out.println("idade: ");
            novoParticipante.put("idade", 20);
            System.out.println("numero celular: ");
            novoParticipante.put("numCelular", "9999-9999");
            System.out.println("numero emergencia: ");
            novoParticipante.put("numEmergencia", "9999-8888");
            System.out.println("tipo sanguineo: ");
            novoParticipante.put("sangue", "AB+");
            novoParticipante.put("valor", custoInscricao((Integer) novoParticipante.get("idade"), categoriaEscolhida));

            if (categoriaEscolhida == 1) {
                novoParticipante.put("numeroIncricao", circuitoPequeno.size() + 1);
                circuitoPequeno.add(novoParticipante);
            }
            else if (categoriaEscolhida == 2) {
                novoParticipante.put("numeroIncricao", circuitoMedio.size() + 1);
                circuitoMedio.add(novoParticipante);
            }
            else {
                novoParticipante.put("numeroIncricao", circuitoAvancado.size() + 1);
                circuitoAvancado.add(novoParticipante);
            }


        }
        return true;
    }

    public static float custoInscricao(int idade, int circuito) {
        float valor = 0;

        if (circuito == 1) {
            if (idade < 18 )
                valor = 1300;
            else
                valor = 1500;
        }
        else if (circuito == 2) {
            if (idade < 18 )
                valor = 2000;
            else
                valor = 2300;
        }
        else if (circuito == 3) {
            valor = 2800;
        }

        return valor;
    }

    public static void removeParticipante(int numeroDeInscricao, String circuito) {


    }

}
