import lombok.Getter;


@Getter
public abstract class Conta implements IConta {

  private static final int AGENCIA_PADRAO = 1;
  private static int SEQUENCIAL = 1;

      // Definindo limites de saque e depósito
  protected static final double LIMITE_SAQUE = 500.00; // limite de saque
  protected static final double LIMITE_DEPOSITO = 10000.00; // limite de depósito
  
  protected int agencia;
  protected int numero;
  protected double saldo;
  protected Cliente cliente;

  public Conta(Cliente cliente) {
    this.agencia = Conta.AGENCIA_PADRAO;
    this.numero = SEQUENCIAL++;
    this.cliente = cliente;
  }

  protected void imprimirInfosComuns() {
    System.out.println(String.format("Titular: %s", this.cliente.getNome()));
    System.out.println(String.format("Agencia: %d", this.agencia));
    System.out.println(String.format("Numero: %d", this.numero));
    System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    
  }


  @Override
  public void sacar(double valor) {
    if (valor > 0 && valor <= this.saldo && valor <= LIMITE_SAQUE) {
      saldo -= valor;
  } else {
      System.out.println("Valor inválido ou acima do limite de saque.");
  }
  }

  @Override
  public void depositar(double valor) {
    if (valor > 0 && valor <= LIMITE_DEPOSITO) {
      saldo += valor;
  } else {
      System.out.println("Depósito acima do limite permitido.");
  }
  }

  @Override
  public void transferir(double valor, IConta contaDestino) {
    if (valor > 0 && valor <= this.saldo && valor <= LIMITE_SAQUE) {
      this.sacar(valor);
      contaDestino.depositar(valor);
  } else {
      System.out.println("Valor inválido ou acima do limite de transferência.");
  }
  }






}