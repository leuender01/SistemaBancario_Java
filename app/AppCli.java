package app;

import app.Execoes.ContaJaExisteExeption;
import app.Execoes.NomeGrandeExeption;
import app.Execoes.SaldoInsuficienteExeption;
import app.Execoes.ContaNaoExisteExeption;

import java.util.Scanner;

public class AppCli{
    private Scanner sc = new Scanner(System.in);
    private Banco banco = new Banco(1);
    public void sectionBanco()
    {
        boolean rodando = true;
        while (rodando) {
            int options;
            Menu.optionsBanco();
            try{
                options = this.sc.nextInt();
                this.sc.nextLine();
            }catch (Exception e){
                System.out.println("Digite uma opcao valida");
                options = 7;
            }
            String entradaString;
            switch (options) {
                case 0:
                    try {
                        entradaString = this.sc.nextLine();
                        banco.genContaPoupanca(entradaString);
                    } catch (NomeGrandeExeption e) {
                        System.out.println(e.getMessage());
                    }catch (SaldoInsuficienteExeption e){
                        System.out.println(e.getMessage());
                    } catch (Exception e){
                        System.out.println("Digite uma opçao valida!");
                    }
                    break;

                case 1:
                    try {
                        System.out.println("Digite nome para Conta");
                        entradaString = this.sc.nextLine();
                        banco.genContaCorrente(entradaString);
                    } catch (NomeGrandeExeption e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e){
                        System.out.println("Digite um nome valido!");
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Digite nome da Conta");
                        entradaString = this.sc.nextLine();
                        ContaCorrente conta = banco.loginContaCorrente(entradaString);
                        sectionConta(conta);
                    }catch (ContaJaExisteExeption e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Digite um nome valido!");
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Digite nome da Conta");
                        entradaString = this.sc.nextLine();
                        ContaPoupanca conta = banco.loginContaPoupanca(entradaString);
                        sectionConta(conta);
                    }catch (ContaNaoExisteExeption e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Digite um nome valido!");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Digite nome da Conta");
                        entradaString = this.sc.nextLine();
                        ContaCorrente conta = banco.loginContaCorrente(entradaString);
                        sectionConta(conta);
                    }catch (ContaNaoExisteExeption e){
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Digite um nome valido!");
                    }
                    break;
                case 5:
                    System.out.println(banco);
                    aguardar(2000);
                    break;
                case 6:
                    rodando = false;
                    break;
                default:
                    System.out.println("Digite uma opçao Valida!");
                    break;
            }
        }
        this.sc.close();
    }

    private void aguardar(int ms)
    {
            try {
                Thread.sleep(ms);
                
            } catch (InterruptedException e) {
                return;
            }
    }
    private void sectionConta(ContaCorrente conta)
    {
    }
    private void sectionConta(ContaPoupanca conta)
    {
    }
}

