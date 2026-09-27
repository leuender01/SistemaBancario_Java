package app;
import java.util.HashMap;
import java.util.Map;
import app.interfaces.BancoInterface;

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
    public boolean genConta(String name) {
        if(this.contasCorrrentes.containsKey(name)) return false;
        ContaCorrente newConta = new ContaCorrente(name, this.agencia, this.lastContaCorrente);
        this.contasCorrrentes.put(name, newConta);
        this.lastContaCorrente++;
        return true;
    }
    
    @Override
    public boolean genConta(String name, String dataAniversario) {
        if(this.contasPoupanca.containsKey(name)) return false;
        ContaPoupanca newConta = new ContaPoupanca(name, this.agencia, this.lastContaPoupanca, dataAniversario);
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
    public void Secion() {
        Menu.optionsBanco();
        
    }
}
