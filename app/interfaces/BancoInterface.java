package app.interfaces;


public interface BancoInterface {
    boolean genConta(String name);
    boolean genConta(String name, String dataAniversario);
    void Secion();
    String getSaldoContas();
}
