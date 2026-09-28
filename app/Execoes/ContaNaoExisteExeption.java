package app.Execoes;

public class ContaNaoExisteExeption extends RuntimeException{
    public ContaNaoExisteExeption(){
        super("Conta nao existe");
    }
}
