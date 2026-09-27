package app;

public class Menu{
    private static final String[] bancoOpcoes = {"[0] Criar-Conta", "[1] Entrar Conta", "[2] Saldo do Banco"};
    private static final String[] contaCorrenteOpcoes = {"[0] Criar-Conta", "[1] Entrar Conta", "[2] Saldo do Banco"};
    private static final String[] contaPoupancaOpcoes = {"[0] Criar-Conta", "[1] Entrar Conta", "[2] Saldo do Banco"};

    static public void optionsBanco()
    {
        for(String banco : bancoOpcoes)
        {
            System.out.println(banco);
        }
    }

    static public void optionsContaCorrente()
    {
        for(String conta : contaCorrenteOpcoes)
        {
            System.out.println(conta);
        }
        
    }

    static public void optionsContaPoupanca()
    {
        for(String conta : contaPoupancaOpcoes)
        {
            System.out.println(conta);
        }

    }
}

