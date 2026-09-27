package app.Execoes;

public class SaldoInsuficienteExeption extends RuntimeException{
    public SaldoInsuficienteExeption(){
        super("SaldoInsuficiente");
    }
}

