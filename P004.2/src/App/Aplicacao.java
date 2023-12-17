package App;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Model.ItemPedido;
import Model.Pedido;

public class Aplicacao {

    public static void main(String[] args) {
    	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        
        Pedido pedido1 = new Pedido("P-0456", "440.734.050-98");
        
        pedido1.adicionarItem("Produto A", 36.55);
        pedido1.adicionarItem("Produto B", 27.07);
        
        pedido1.exibirInformacoes();
        System.out.println("\nTotal do Pedido sem desconto: " + currencyFormat.format(pedido1.calcularTotal(0)));

        System.out.println("\n----------------------------------------------------\n");

        Pedido pedido2 = new Pedido("P-0457", "754.028.700-47");
        List<ItemPedido> itensPedido2 = new ArrayList<>();
        
        itensPedido2.add(new ItemPedido("Produto C", 67.53));
        itensPedido2.add(new ItemPedido("Produto D", 75.31));
        
        pedido2.adicionarItem(itensPedido2);
        pedido2.exibirInformacoes();
        System.out.println("\nTotal do Pedido com 10% de desconto: R$ " + currencyFormat.format(pedido2.calcularTotal(10)));
    }	
	
}
