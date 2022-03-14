package ex1;

import java.math.BigDecimal;

public abstract class Cliente {

    Deposito deposito = new Deposito();
    Transferencia transferencia = new Transferencia();
    ConsultaDeSaldo consultaDeSaldo = new ConsultaDeSaldo();
    SaqueEmDinheiro saqueEmDinheiro = new SaqueEmDinheiro();
    PagamentodeServicos pagamentodeServicos = new PagamentodeServicos();

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
        deposito.transacaoNaoOk();
    }

    public void realizaTransferencia(Cliente clienteBeneficiado, BigDecimal valor) {
        transferencia.transacaoNaoOk();
    }

    public void realizaSaqueEmDinheiro(BigDecimal valor) {
        saqueEmDinheiro.transacaoNaoOk();
    }

    public void realizaConsultaDeSaldo() {
        consultaDeSaldo.transacaoNaoOk();
    }
    public void realizaPagamentoDeServicos() {
        pagamentodeServicos.realizaPagamentodeServicos();
    }
}
