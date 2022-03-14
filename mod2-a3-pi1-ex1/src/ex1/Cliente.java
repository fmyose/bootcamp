package ex1;

import java.math.BigDecimal;

public abstract class Cliente {

    private String id;
    private String nome;
    private BigDecimal saldo;

    public Cliente() {};

    public Cliente(String id, String nome, BigDecimal saldo) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void realizaDeposito(BigDecimal valor) {
        Transacao.transacaoNaoOk();
    }

    public void realizaTransferencia(Cliente clienteBeneficiado, BigDecimal valor) {
        Transacao.transacaoNaoOk();
    }

    public void realizaSaqueEmDinheiro(BigDecimal valor) {
        Transacao.transacaoNaoOk();
    }

    public void realizaConsultaDeSaldo() {
        Transacao.transacaoNaoOk();
    }
    public void realizaPagamentoDeServicos() {
        Transacao.transacaoNaoOk();
    }
}
