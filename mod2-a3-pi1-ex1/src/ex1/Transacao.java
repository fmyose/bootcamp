package ex1;

public interface Transacao {

    default boolean transacaoOk() {
        System.out.println("Transacao OK");
        return true;
    }

    default boolean transacaoNaoOk() {
        System.out.println("Transacao nao OK");
        return false;
    }

}
