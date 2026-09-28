package app.Execoes;

public class ContaJaExisteExeption extends RuntimeException{
    public ContaJaExisteExeption(){
        super("Conta Já existe!");
    }
    
}

