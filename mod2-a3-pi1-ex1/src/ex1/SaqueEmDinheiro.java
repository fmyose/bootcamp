package ex1;

import java.math.BigDecimal;

public class SaqueEmDinheiro implements Transacao {
    public static void realizaSaqueEmDinheiro(Cliente cliente, BigDecimal valor) {
        if (cliente.getSaldo().compareTo(valor) != -1) {
            cliente.setSaldo(cliente.getSaldo().subtract(valor));
            System.out.println("Saque realizado: " + valor);
            return;
        }

        System.out.println("Saldo insuficiente");
    }

}
