package app;
import app.Execoes.SaldoInsuficienteExeption;

public class ContaCorrente extends Conta
{
    private double balance = 0;
    public ContaCorrente(String name, int agencia, int conta)
    {
        super(name, agencia, conta);
    }

    public double getSaldo()
    {
        return balance;
    }

    public boolean deposit(double value)
    {
        this.balance += value;
        super.extrato.push("Value + R$ " + value + " [ " + getData() + " ]");
        return true;
    }
    public boolean saque(double value) throws SaldoInsuficienteExeption
    {
        if(value > this.balance) {
            super.extrato.push("Valor Insuficiente " + value + " maior que o saldo " +  " [ " + getData() + " ]");
            throw new SaldoInsuficienteExeption(); 
        };
        super.extrato.push("Value - R$ " + value + " [ " + getData() + " ]");
        this.balance -= value;
        return true;
    }
}
