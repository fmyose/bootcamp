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
            System.out.println("4. verificar valor da inscrição");
            System.out.println("0. sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    inscricao();
                    break;
                case 2:
                    listarCadastrosPorCategoria();
                    break;
                case 3:
                    removeParticipante();
                    break;
                case 4:
                    valorAPagar();
                    break;
                case 0:
                    System.out.println("Até a próxima!");
                    break;
            }
        }
    }

    public static void inscricao() {
        HashMap<String, Object> novoParticipante = new HashMap<>();

        System.out.println("Qual categoria? \n1. pequeno\n2. medio\n3.avancado\n");
        int categoriaEscolhida = scanner.nextInt();
        System.out.println("idade: ");
        int idadeParticipante = scanner.nextInt();
        if (categoriaEscolhida == 3 && idadeParticipante < 18) {
            System.out.println("nao permitido");
        }
        else {
            novoParticipante.put("idade", idadeParticipante);
            System.out.println("RG: ");
            novoParticipante.put("RG", scanner.next());
            System.out.println("nome: ");
            novoParticipante.put("nome", scanner.next());
            System.out.println("sobrenome: ");
            novoParticipante.put("sobrenome", scanner.next());
            System.out.println("numero celular: ");
            novoParticipante.put("numCelular", scanner.next());
            System.out.println("numero emergencia: ");
            novoParticipante.put("numEmergencia", scanner.next());
            System.out.println("tipo sanguineo: ");
            novoParticipante.put("sangue", scanner.next());

            novoParticipante.put("valor", custoInscricao((int) novoParticipante.get("idade"), categoriaEscolhida));

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
            System.out.printf("Inscrição finalizada");
        }
    }

    public static String custoInscricao(int idade, int circuito) {
        String valor = "";

        if (circuito == 1) {
            if (idade < 18 )
                valor = "1300";
            else
                valor = "1500";
        }
        else if (circuito == 2) {
            if (idade < 18 )
                valor = "2000";
            else
                valor = "2300";
        }
        else if (circuito == 3) {
            valor = "2800";
        }
        return valor;
    }

    public static void removeParticipante() {
        int escolha = 1;
        System.out.println("Qual o numero da inscricao que voce deseja remover?");
        int numeroInscricao = scanner.nextInt();
        System.out.println("De qual categoria voce deseja excluir a inscricao?\n1.pequeno \n2.medio \n3.avancado");
        escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                for (int i = 0; i < circuitoPequeno.size(); i++) {

                    if (numeroInscricao == (Integer) circuitoPequeno.get(i).get("numeroIncricao")) {
                        circuitoPequeno.remove(i);
                        System.out.println("Removido com sucesso");
                    }

                }
                break;
            case 2:
                for (int i = 0; i < circuitoMedio.size(); i++) {
                    if (numeroInscricao == (Integer) circuitoMedio.get(i).get("numeroIncricao")) {
                        circuitoMedio.remove(i);
                        System.out.println("Removido com sucesso");
                    }

                }
                break;
            case 3:
                for (int i = 0; i < circuitoAvancado.size(); i++) {
                    if (numeroInscricao == (Integer) circuitoAvancado.get(i).get("numeroIncricao")) {
                        circuitoAvancado.remove(i);
                        System.out.println("Removido com sucesso");
                    }

                }
                break;
        }
    }

    public static void listarCadastrosPorCategoria() {
        int escolha = 1;
        System.out.println("Qual categoria voce deseja listar?\n1.pequeno \n2.medio \n3.avancado");
        int escolhaCategoria = scanner.nextInt();
        switch (escolhaCategoria) {
            case 1:
                for (int i = 0; i < circuitoPequeno.size(); i++) {
                    criacaoLista(circuitoPequeno.get(i));
                }
                break;
            case 2:
                for (int i = 0; i < circuitoMedio.size(); i++) {
                    criacaoLista(circuitoMedio.get(i));
                }
                break;
            case 3:
                for (int i = 0; i < circuitoAvancado.size(); i++) {
                    criacaoLista(circuitoAvancado.get(i));
                }
                break;
        }
    }

    public static void criacaoLista(HashMap inscrito) {
        System.out.println("Inscrição " + inscrito.get("numeroIncricao") + ":");
        System.out.println("Nome: " + inscrito.get("nome") + " | " + "Sobrenome: " + inscrito.get("sobrenome")
                + " | " + "RG: " + inscrito.get("RG") + " | " + "Idade: " + inscrito.get("idade") + " | "
                + "Telefone celular: " + inscrito.get("numCelular") + " | " + "Telefone de emergencia:"
                + inscrito.get("numEmergencia") + " | " + "Tipo Sanguíneo: " + inscrito.get("sangue") + " | "
                + "Valor a pagar: " + inscrito.get("valor"));
    }

    public static void valorAPagar() {

        System.out.println("Qual categoria? \n1. pequeno\n2. medio\n3.avancado");
        int categoriaInput = Integer.parseInt(scanner.next());
        System.out.println("Digite o RG do participante:");
        String rgInput = scanner.next();
        System.out.println(categoriaInput);

        switch (categoriaInput) {
            case 1:
                calculoValorPorCircuito(circuitoPequeno, rgInput);
                break;
            case 2:
                calculoValorPorCircuito(circuitoMedio, rgInput);
                break;
            case 3:
                calculoValorPorCircuito(circuitoAvancado, rgInput);
                break;
        }
    }

    public static void calculoValorPorCircuito(List<HashMap<String,Object>>circuito, String rg) {
        for (int i = 0; i < circuito.size(); i++) {
            HashMap inscrito;
            inscrito = circuito.get(i);
            if (inscrito.get("RG").equals(rg)) {
                System.out.println("Valor: " + inscrito.get("valor"));
                return;
            } else {
                System.out.println("RG nao cadastrado");
            }
        }
    }


}
