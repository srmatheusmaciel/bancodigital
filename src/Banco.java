import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Banco {
  private String nome;
 
  private List<Conta> contas;
  private List<Cliente> clientes;

  public Banco() {
    this.contas = new ArrayList<>();
    this.clientes = new ArrayList<>();
  }

  public void listarContas(){
    System.out.println("Listagem de Contas" + this.nome + ":");
    for (Conta conta : this.contas) {
      System.out.println(conta.getCliente().getNome());
    }
}

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public void removerConta(Conta conta) {
    this.contas.remove(conta);
  }

  public boolean clienteExiste(Cliente cliente) {
    return clientes.contains(cliente);
}

public void adicionarCliente(Cliente cliente) {
  if (!clienteExiste(cliente)) {
      clientes.add(cliente);
  } else {
      System.out.println("Cliente já existe.");
  }
}

}