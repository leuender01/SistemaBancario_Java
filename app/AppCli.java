package app;

import app.Execoes.ContaJaExisteExeption;
import app.Execoes.ContaNaoExisteExeption;
import app.Execoes.NomeGrandeExeption;
import app.Execoes.SaldoInsuficienteExeption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppCli
{
    private static Banco banco = new Banco(1);
    private static Scanner sc = new Scanner(System.in);
    public static void section()
    {
        boolean rodando = true;
        while (rodando) {
            System.out.print("\033[H\033[2J");
            Menu.optionsBanco();
            try {
                switch (getInt()) {
                    case 0:
                        genContaPoupanca();
                        break;
                    case 1:
                        genContaCorrente();
                        break;
                    case 2:
                        loginContaCorrente();
                        break;
                    case 3:
                        loginContaPoupanca();
                        break;
                    case 4:
                        System.out.println(banco.getSaldoContas());
                        aguardar(1200);
                        break;
                    case 5:
                        System.out.println(banco);
                        aguardar(3000);
                        break;
                    case 6:
                        rodando = false;
                        break;

                    default:
                        System.out.println("Digite uma opção valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas numeros Ex: 1");
            }
        }
        sc.close();
    } 

    private static void genContaCorrente()
    {
        try {
            System.out.println("Digite nome para a conta!");
            banco.genContaCorrente(getString());
        } catch (ContaJaExisteExeption e) {
            System.out.println(e.getMessage());
        }catch (NomeGrandeExeption e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private static void genContaPoupanca()
    {
        try {
            System.out.println("Digite nome para a conta!");
            banco.genContaPoupanca(getString());
        } catch (ContaJaExisteExeption e) {
            System.out.println(e.getMessage());
        }catch (NomeGrandeExeption e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static void loginContaPoupanca()
    {
        System.out.println("Digite o nome da conta!");
        String nomeConta = getString();
        ContaPoupanca conta = banco.loginContaPoupanca(nomeConta);
        boolean rodando = true;
        while (rodando) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.println("Saldo: " + conta.getSaldo());
                Menu.optionsConta();
                switch (getInt()) {
                        case 0:
                            System.out.println("Digite um valor para Sacar em R$ ");
                            conta.saque(getDouble());
                            break;
                        case 1:
                            System.out.println("Digite um valor para Depositar em R$ ");
                            conta.deposit(getDouble());
                            break;
                        case 2:
                            System.out.println(conta.getExtrato());
                            aguardar(1200);
                            break;
                        case 3:
                            System.out.println(conta);
                            aguardar(3000);
                            break;
                        case 4:
                            rodando = false;
                            break;
                        default:
                            System.out.println("Digite um opção valida!");
                            break;
                }
            } catch (SaldoInsuficienteExeption e) {
                System.out.println(e.getMessage());
                aguardar(1200);
                continue;
            } catch (ContaNaoExisteExeption e) {
                System.out.println(e.getMessage());
                aguardar(1200);
                continue;
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor valido!");
                continue;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
        return;
    }

    private static void loginContaCorrente()
    {
        System.out.println("Digite o nome da conta!");
        String nomeConta = getString();
        ContaCorrente conta = banco.loginContaCorrente(nomeConta);
        boolean rodando = true;
        while (rodando) {
            try {
                System.out.print("\033[H\033[2J");
                System.out.println("Saldo: " + conta.getSaldo());
                Menu.optionsConta();
                switch (getInt()) {
                        case 0:
                            System.out.println("Digite um valor para Sacar em R$ ");
                            conta.saque(getDouble());
                            break;
                        case 1:
                            System.out.println("Digite um valor para Depositar em R$ ");
                            conta.deposit(getDouble());
                            break;
                        case 2:
                            System.out.println(conta.getExtrato());
                            aguardar(3000);
                            break;
                        case 3:
                            System.out.println(conta);
                            aguardar(3000);
                            break;
                        case 4:
                            rodando = false;
                            break;
                        default:
                            System.out.println("Digite um opção valida!");
                            break;
                }
            } catch (SaldoInsuficienteExeption e) {
                System.out.println(e.getMessage());
                aguardar(1200);
            } catch (ContaNaoExisteExeption e) {
                System.out.println(e.getMessage());
                aguardar(1200);
            } catch (InputMismatchException e) {
                System.out.println("Digite um valor valido!");
                aguardar(1200);
                continue;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return;

    }

    private static String getString()
    {
        return sc.nextLine();
    }

    private static int getInt()
    {
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }
    private static double getDouble()
    {
        double result = sc.nextDouble();
        sc.nextLine();
        return result;
    }
    private static void aguardar(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}

