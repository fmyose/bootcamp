package ex1;

import java.math.BigDecimal;

public class ClienteExecutivo extends Cliente {

    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();

    public ClienteExecutivo() {
    }

    public ClienteExecutivo(String id, String nome, BigDecimal saldo) {
        super(id, nome, saldo);
    }

    @Override
    public void realizaDeposito(BigDecimal valor) {
        saqueEmDinheiro.transacaoOk();
        deposito.realizaDeposito(this, valor);
    }

    @Override
    public void realizaTransferencia(Cliente clienteBeneficiado, BigDecimal valor) {
        saqueEmDinheiro.transacaoOk();
        transferencia.realizaTransferencia(this, clienteBeneficiado, valor);
    }

}
