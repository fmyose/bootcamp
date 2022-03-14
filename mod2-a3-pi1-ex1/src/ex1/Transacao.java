package ex1;

public interface Transacao {

    static boolean transacaoOk() {
        return false;
    }

    static boolean transacaoNaoOk() {
        return false;
    }

}
