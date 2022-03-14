package ex1;

import java.math.BigDecimal;

public class ClienteCobrador extends Cliente {

    public ClienteCobrador() {
    }

    public ClienteCobrador(String id, String nome, BigDecimal saldo) {
        super(id, nome, saldo);
    }

    @Override
    public void realizaSaqueEmDinheiro(BigDecimal valor) {
        saqueEmDinheiro.transacaoOk();
        SaqueEmDinheiro.realizaSaqueEmDinheiro(this, valor);
    }

    @Override
    public void realizaConsultaDeSaldo() {
        consultaDeSaldo.transacaoOk();
        consultaDeSaldo.realizaConsulta(this);
    }
}
