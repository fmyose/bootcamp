import ex1.ClienteBasico;
import ex1.ClienteCobrador;
import ex1.ClienteExecutivo;

import java.math.BigDecimal;

public class Main {

    public static void main(String args[]) {

        System.out.println("--------------------------------\n--------------------------------");
        System.out.println("ex. 1");

        System.out.println("----------------");
        System.out.println("Cobrador");
        ClienteCobrador clienteCobrador = new ClienteCobrador("002", "cobrador002", BigDecimal.valueOf(1000));
        clienteCobrador.realizaSaqueEmDinheiro(BigDecimal.valueOf(300));
        clienteCobrador.realizaConsultaDeSaldo();
        clienteCobrador.realizaDeposito(BigDecimal.valueOf(100));

        System.out.println("----------------");
        System.out.println("Executivo");
        ClienteExecutivo clienteExecutivo = new ClienteExecutivo("001", "executivo001", BigDecimal.valueOf(1000));
        clienteExecutivo.realizaDeposito(BigDecimal.valueOf(1000));
        clienteExecutivo.realizaTransferencia(clienteCobrador, BigDecimal.valueOf(222));
        clienteCobrador.realizaConsultaDeSaldo();

        System.out.println("----------------");
        System.out.println("Basico");
        ClienteBasico clienteBasico = new ClienteBasico("003", "basico003", BigDecimal.valueOf(3000));
        clienteBasico.realizaPagamentoDeServicos();
        clienteBasico.realizaSaqueEmDinheiro(BigDecimal.valueOf(400));
        clienteBasico.realizaConsultaDeSaldo();

        System.out.println("--------------------------------\n--------------------------------");

    }
}
