package app;
import java.util.HashMap;
import java.util.Map;
import app.interfaces.BancoInterface;

public class Banco implements BancoInterface{
    private int agencia;
    private int lastcont = 0;
    Map<String ,Conta> accounts = new HashMap<>();
    
    public Banco(int agencia){
       this.agencia = agencia;
    }

    public Conta Login(String name){
        Conta result = this.accounts.get(name);
        return result;
    }
    @Override
    public boolean genConta(String name) {
        if(this.accounts.containsKey(name)) return false;
        Conta newConta = new Conta(name, this.agencia, this.lastcont);
        this.accounts.put(name, newConta);
        return true;
    }
    public double getsaldo(){
        double result = 0;
        for(Map.Entry<String, Conta> count : this.accounts.entrySet()){
            if(count != null) result += count.getValue().saldo();
        }
        return result;
    }
}
