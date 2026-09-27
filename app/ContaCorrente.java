package app;
import app.Execoes.SaldoInsuficienteExeption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContaCorrente extends Conta
{
    private GerarExtrato extrato = new GerarExtrato(); 
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
        this.extrato.push("Value + R$ " + value + " [ " + getData() + " ]");
        return true;
    }
    public boolean saque(double value) throws SaldoInsuficienteExeption
    {
        if(value > this.balance) {
            this.extrato.push("Valor Insuficiente " + value + " maior que o saldo " +  " [ " + getData() + " ]");
            throw new SaldoInsuficienteExeption(); 
        };
        this.extrato.push("Value - R$ " + value + " [ " + getData() + " ]");
        this.balance -= value;
        return true;
    }
    private String getData()
    {
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
        return dataAtual.format(dataFormatada);
    }

    public String getExtrato(){
        return this.extrato.toString();
    }
}
