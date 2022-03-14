package ex1;

import java.math.BigDecimal;

public class Deposito implements Transacao {
    public static void realizaDeposito(Cliente cliente, BigDecimal valor) {
        System.out.println("Realizando deposito: " + valor);
        cliente.setSaldo(cliente.getSaldo().add(valor));
    }
}
