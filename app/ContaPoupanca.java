package app;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import app.Execoes.SaldoInsuficienteExeption;

public class ContaPoupanca extends Conta{
    private final double redimentoMensal = 8.5;
    private double balance;
    private String dataNext = null;

    public ContaPoupanca(String name, int conta, int agencia)
    {
        super(name, agencia, conta);
        this.dataNext = getData();
    }
    private void nextData()
    {
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
        LocalDateTime novaData = (this.dataNext == null) ? LocalDateTime.parse(getData(), dataFormatada) : LocalDateTime.parse(this.dataNext, dataFormatada);
        novaData = novaData.plusMonths(1);
        this.dataNext = novaData.format(dataFormatada);
    }

    public boolean deposit(double value)   
    {
        this.balance += value;
        super.extrato.push("Value + R$ " + value + " [ " + getData() + " ]");
        return true;
    }
    public void aplicarRendimentos()
    {
        String dataAtual = getData();
        if(dataAtual.equals(dataNext))
        {
            nextData();
            double novoBalance = (this.balance / 100 ) * this.redimentoMensal;
            this.balance += novoBalance;
        }
    }

    public boolean saque(double value) throws SaldoInsuficienteExeption
    {
        if( value > this.balance){ 
            super.extrato.push("Valor Insuficiente " + value + " maior que o saldo " +  " [ " + getData() + " ]");
            throw new SaldoInsuficienteExeption();
        }
        super.extrato.push("Value - R$ " + value + " [ " + getData() + " ]");
        return true;
    }

    public double getSaldo(){
        return balance;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nRedimento Mensal: " + redimentoMensal + "%" + "\nData Vencimento: " + dataNext;
    }
}

