package app.interfaces;


public interface BancoInterface {
    boolean genContaPoupanca(String name);
    boolean genContaCorrente(String name);
    String getSaldoContas();
}
