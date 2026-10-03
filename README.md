# Sistema Bancário

Projeto de estudo em **Java** para praticar **Orientação a Objetos** (classes abstratas, herança, interfaces, encapsulamento, polimorfismo e exceções personalizadas). O sistema simula um banco simples, operado por uma interface de linha de comando (CLI).

## Requisitos

Os requisitos completos estão em [`Requisitos.md`](Requisitos.md).

**Funcionais**
- **Banco:** gerencia as contas, pode criar uma ou mais contas e deve ser tolerante a falhas.
- **Conta:** pode sacar e depositar qualquer valor.

**Não funcionais**
- **Conta:** gera extratos individuais.

## Funcionalidades

- Criação de contas **corrente** e **poupança**.
- Depósito e saque, com erro de saldo insuficiente.
- Extrato individual por conta (registra depósitos, saques e tentativas de saque recusadas, com data e hora).
- Rendimento mensal na poupança (8,5%).
- Consulta do saldo total do banco e listagem das contas.
- Tratamento de entradas inválidas no menu (por exemplo, texto onde se espera um número).

## Estrutura do projeto

```
app/
├── App.java                 # Ponto de entrada (main)
├── AppCli.java              # Interface de linha de comando (loop do menu)
├── Menu.java                # Opções exibidas nos menus
├── Banco.java               # Gerencia as contas (implements BancoInterface)
├── Conta.java               # Classe abstrata base (implements ContaInterface)
├── ContaCorrente.java       # Conta corrente (extends Conta)
├── ContaPoupanca.java       # Conta poupança com rendimento (extends Conta)
├── GerarExtrato.java        # Armazena o histórico de movimentações
├── interfaces/
│   ├── BancoInterface.java
│   └── ContaInterface.java  # Define LIMIT_STRING = 12 (tamanho máximo do nome)
└── Execoes/
    ├── ContaJaExisteExeption.java
    ├── ContaNaoExisteExeption.java
    ├── NomeGrandeExeption.java
    └── SaldoInsuficienteExeption.java
```

## Conceitos de OO praticados

| Conceito | Onde aparece |
|---|---|
| Classe abstrata | `Conta` |
| Herança | `ContaCorrente` e `ContaPoupanca` estendem `Conta` |
| Interfaces | `BancoInterface`, `ContaInterface` |
| Encapsulamento | Atributos privados com getters (`getSaldo`, `getName`) |
| Sobrescrita | `toString`, `equals` e `hashCode` |
| Composição | `Conta` possui um `GerarExtrato`; `Banco` possui mapas de contas |
| Exceções personalizadas | Pacote `Execoes` |

## Exceções

| Exceção | Quando ocorre |
|---|---|
| `ContaJaExisteExeption` | Já existe uma conta do mesmo tipo com esse nome |
| `ContaNaoExisteExeption` | Login em uma conta inexistente |
| `NomeGrandeExeption` | Nome com mais de 12 caracteres |
| `SaldoInsuficienteExeption` | Saque maior que o saldo |

## Como executar

Requer o **JDK** instalado. A partir da raiz do repositório:

```bash
javac app/*.java app/Execoes/*.java app/interfaces/*.java
java app.App
```

## Uso

Ao iniciar, o menu principal é exibido:

```
[0] Criar-Conta-Poupança
[1] Criar-Conta-Corrente
[2] Entrar Conta-Corrente
[3] Entrar Conta-Poupança
[4] Saldo do Banco
[5] Listar Banco
[6] Sair
```

Depois de entrar em uma conta, o menu da conta oferece:

```
[0] Sacar
[1] Depositar
[2] Extrato
[3] info
[4] Sair
```

## Limitações conhecidas

Este é um projeto de aprendizado, e algumas partes ainda estão em evolução:

- Os dados ficam apenas em memória e são perdidos ao encerrar o programa.
- As contas são identificadas pelo nome, sem autenticação por senha.
- O rendimento da poupança só é aplicado se `aplicarRendimentos()` for chamado exatamente no instante do vencimento, então ainda não funciona de forma automática.
