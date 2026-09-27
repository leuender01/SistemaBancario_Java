package app.interfaces;

public interface ContaInterface {
    final int  LIMIT_STRING = 12;
    double saldo();
    boolean sacar(double value);
    boolean deposit(double value);
}
