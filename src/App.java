public class App {
    
    public static void main(String[] args) {
        
        // Criar o banco
        Banco banco = new Banco();
        banco.setNome("Banco Digital");

        // Criar clientes
        Cliente luke = new Cliente("Luke");
        Cliente leia = new Cliente("Leia");

       
        banco.adicionarCliente(luke);
        banco.adicionarCliente(leia);

        // Criar contas
        Conta cc = new ContaCorrente(luke);
        Conta poupanca = new ContaPoupanca(leia);

        // Adicionar contas ao banco
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        // Realizar operações
        // Depositar em contas
        cc.depositar(100);
        poupanca.depositar(200);

        // Saques
        cc.sacar(50);  // Saque válido
        poupanca.sacar(300);  // Saque inválido (acima do saldo)

        // Transferência entre contas
        cc.transferir(30, poupanca);  // Transferência válida
        cc.transferir(100, poupanca);  // Transferência inválida (acima do saldo)

        // Imprimir extratos
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
