package app;
import app.interfaces.ContaInterface;

public class Conta implements ContaInterface{
    private double saldo = 0;
    private int conta;
    private String name;
    private int agencia;
    
    public Conta(String name, int agencia, int conta){
        this.agencia = agencia;
        this.conta = conta;
        setName(name);
    }

    private void setName(String name){
        int nameLenght = name.length();
        if(nameLenght > LIMIT_STRING){
            this.name = name.substring(0, nameLenght);
        }else{
            this.name = name;
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public double saldo(){
        return this.saldo;
    }
    @Override
    public boolean deposit(double value){
        this.saldo += value;
        return true;
    }
    @Override
    public boolean sacar(double value){
        if(value > this.saldo){
            return false;
        }
        this.saldo -= value;
        return true;
    }
    @Override
    public String toString() {
        return "Agencia: " + agencia + "\n\r" + "Name: " + name + "\n\r" + "Conta: " + conta + "\n";
    }
}

