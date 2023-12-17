package Model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private String numeroPedido;
	private String cpfCliente;
	private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(String numeroPedido, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.cpfCliente = cpfCliente;
    }

    public void adicionarItem(String nomeItem, double precoItem) {
        itens.add(new ItemPedido(nomeItem, precoItem));
    }

    public void adicionarItem(List<ItemPedido> listaItens) {
        itens.addAll(listaItens);
    }

    public double calcularTotal(double percentualDesconto) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        
        return total * (1 - percentualDesconto / 100);
    }

    public double calcularTotal(int numPrestacoes, double juro) {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        
        return total * (1 + juro / 100) / numPrestacoes;
    }

    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpfCliente);
        
        System.out.println("\nItens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("* " + item.getNome() + ": R$ " + item.getPreco());
        }
    }
    
}
