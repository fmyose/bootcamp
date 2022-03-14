package ex1;

import java.math.BigDecimal;

public class Transferencia implements Transacao {
    public static void realizaTransferencia(Cliente origem, Cliente destino, BigDecimal valor) {
        if (origem.getSaldo().compareTo(valor) != -1) {
            origem.setSaldo(origem.getSaldo().subtract(valor));
            destino.setSaldo(destino.getSaldo().add(valor));
            System.out.println("Transferencia realizada: " + valor + " | " + origem.getId() + " -> " + destino.getId());
            return;
        }

        System.out.println("Saldo insuficiente");
    }
}
