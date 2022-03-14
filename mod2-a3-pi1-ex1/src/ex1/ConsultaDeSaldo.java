package ex1;

import java.math.BigDecimal;

public class ConsultaDeSaldo implements Transacao {
    public void realizaConsulta(Cliente cliente) {
        System.out.println("Saldo: " + cliente.getSaldo());
    }
}
