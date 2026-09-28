package app;

public class Menu{
    private static final String[] bancoOpcoes = {
        "[0] Criar-Conta-Poupança",
        "[1] Criar-Conta-Corrente",
        "[2] Entrar Conta-Corrente",
        "[3] Entrar Conta-Poupança",
        "[4] Saldo do Banco",
        "[5] Listar Banco",
        "[6] Sair"};
    private static final String[] contaConta = {
        "[0] Sacar",
        "[1] Depositar",
        "[2] Extrato",
        "[3] info",
        "[4] Sair"};

    static public void optionsBanco()
    {
        for(String banco : bancoOpcoes)
        {
            System.out.println(banco);
        }
    }

    static public void optionsConta()
    {
        for(String conta : contaConta)
        {
            System.out.println(conta);
        }

    }
}

