package ex1;

public class ConsultaDeSaldo implements Transacao {
    public static void realizaConsulta(Cliente cliente) {
        System.out.println("Saldo: " + cliente.getSaldo());
    }
}
