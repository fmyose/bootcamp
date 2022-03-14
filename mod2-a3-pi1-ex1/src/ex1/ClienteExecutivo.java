package ex1;

import java.math.BigDecimal;

public class ClienteExecutivo extends Cliente {

    public ClienteExecutivo() {
    }

    public ClienteExecutivo(String id, String nome, BigDecimal saldo) {
        super(id, nome, saldo);
    }

    @Override
    public void realizaDeposito(BigDecimal valor) {
        Transacao.transacaoOk();
        Deposito.realizaDeposito(this, valor);
    }

    @Override
    public void realizaTransferencia(Cliente clienteBeneficiado, BigDecimal valor) {
        Transacao.transacaoOk();
        Transferencia.realizaTransferencia(this, clienteBeneficiado, valor);
    }

}
