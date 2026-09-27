package app;
import java.util.Objects;
import app.Execoes.NomeGrandeExeption;
import app.interfaces.ContaInterface;

public abstract class Conta implements ContaInterface{
    private int cc;
    private String name;
    private int agencia;
    
    public Conta(String name, int agencia, int conta){
        this.agencia = agencia;
        this.cc = conta;
        setName(name);
    }
    private void setName(String name) throws NomeGrandeExeption
    {
        int nameLenght = name.length();
        if(nameLenght > LIMIT_STRING)
        {
            this.name = name.substring(0, nameLenght);
            throw new NomeGrandeExeption();
        }else{
            this.name = name;
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Conta: " + cc + "\n\r" + "Agencia: " + agencia + "\n\r" + "Name :" + name + "\n"; 
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Conta o = (Conta) obj;
        return Objects.equals(o.name, this.name);
    }

}

