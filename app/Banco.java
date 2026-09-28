package app;
import java.util.HashMap;
import java.util.Map;
import app.interfaces.BancoInterface;
import app.Execoes.ContaJaExisteExeption;
import app.Execoes.ContaNaoExisteExeption;
import app.Execoes.NomeGrandeExeption;

public class Banco implements BancoInterface{
    private int agencia;
    private int lastContaCorrente = 0;
    private int lastContaPoupanca = 0;
    Map<String ,ContaCorrente> contasCorrrentes = new HashMap<>();
    Map<String ,ContaPoupanca> contasPoupanca = new HashMap<>();
    
    public Banco(int agencia){
       this.agencia = agencia;
    }

    @Override
    public boolean genContaCorrente(String name) throws ContaJaExisteExeption, NomeGrandeExeption
    {
        if(this.contasCorrrentes.containsKey(name)) throw new ContaJaExisteExeption();
        ContaCorrente newConta = new ContaCorrente(name, this.agencia, this.lastContaCorrente);
        this.contasCorrrentes.put(name, newConta);
        this.lastContaCorrente++;
        return true;
    }
    
    @Override
    public boolean genContaPoupanca(String name) throws ContaJaExisteExeption, NomeGrandeExeption 
    {
        if(this.contasPoupanca.containsKey(name)) throw new ContaJaExisteExeption();
        ContaPoupanca newConta = new ContaPoupanca(name, lastContaPoupanca, agencia);
        this.contasPoupanca.put(name, newConta);
        this.lastContaPoupanca++;
        return true;
    }


    @Override
    public String getSaldoContas(){
        double resultContaCorrente = 0;
        double resultContaPoupanca = 0;
        for(Map.Entry<String, ContaCorrente> count : this.contasCorrrentes.entrySet()){
            if(count != null) resultContaCorrente += count.getValue().getSaldo();
        }
        for(Map.Entry<String, ContaPoupanca> count : this.contasPoupanca.entrySet()){
            if(count != null) resultContaPoupanca += count.getValue().getSaldo();
        }
        return "Saldo Contas Poupança: " + resultContaPoupanca + "\nSaldo Contas Correntes: " + resultContaCorrente;
    }
    @Override
    public String toString() {
        return "Contas Correntes: " + this.contasCorrrentes.toString() + "\n\r Contas Poupança: " + this.contasPoupanca.toString();
    }


    public ContaPoupanca loginContaPoupanca(String name) throws ContaNaoExisteExeption
    {
        ContaPoupanca conta =  this.contasPoupanca.get(name);
        if(conta == null) throw new ContaNaoExisteExeption();
        return conta;
    }

    public ContaCorrente loginContaCorrente(String name) throws ContaNaoExisteExeption
    {
        ContaCorrente conta =  this.contasCorrrentes.get(name);
        if(conta == null) throw new ContaNaoExisteExeption();
        return conta;
    }
}
