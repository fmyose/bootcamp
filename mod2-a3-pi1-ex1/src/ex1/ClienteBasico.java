package ex1;

import java.math.BigDecimal;

public class ClienteBasico extends Cliente {

    public ClienteBasico() {
    }

    public ClienteBasico(String id, String nome, BigDecimal saldo) {
        super(id, nome, saldo);
    }

    @Override
    public void realizaSaqueEmDinheiro(BigDecimal valor) {
        Transacao.transacaoOk();
        SaqueEmDinheiro.realizaSaqueEmDinheiro(this, valor);
    }

    @Override
    public void realizaConsultaDeSaldo() {
        Transacao.transacaoOk();
        ConsultaDeSaldo.realizaConsulta(this);
    }

    @Override
    public void realizaPagamentoDeServicos() {
        Transacao.transacaoOk();
        PagamentodeServicos.realizaPagamentodeServicos();
    }
}
