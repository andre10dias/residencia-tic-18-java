package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Utils.Util;
import menu.Menu;
import models.Fatura;
import models.Imovel;
import models.Pagamento;
import services.FaturaService;
import services.ImovelService;
import services.PagamentoService;

public class PagamentoController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void realizarPagamento() {
		System.out.println("\n======================== Realizar Pagamento ========================");
		
		Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveisComClientes());
		
		Set<Fatura> faturasPendentes = new HashSet<Fatura>(FaturaService.getFaturasPendentesByImovel(imovelSelecionado));
		Fatura faturaSelecionada = Menu.menuSelecionarFatura(new ArrayList<Fatura>(faturasPendentes));
		
		if (faturaSelecionada != null) {			
			System.out.print("\nValor do pagamento: ");
			double valor = Util.stringToDouble(entrada.nextLine());
			
			double valorReembolso = PagamentoService.registraPagamento(faturaSelecionada, valor);
			if (valorReembolso > 0) {				
				System.out.print("\nEste pagamento gerou um reembolso no valor de: " + valorReembolso);
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
		
	}

	public static void listarTodos() {
		System.out.println("\n======================== Listar pagamentos ========================\n");
		
		List<Pagamento> pagamentos = PagamentoService.getPagamentos();
		listar(pagamentos);
	}

	public static void consultarPagFatura() {
		System.out.println("\n======================== Listar pagamentos da fatura ========================\n");
		Set<Fatura> faturas = new HashSet<Fatura>(FaturaService.getFaturas());
		Fatura fatura = Menu.menuSelecionarFatura(new ArrayList<Fatura>(faturas));
		
		try {
			List<Pagamento> pagamentos = PagamentoService.getPagamentosByFatura(fatura);
			listar(pagamentos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void listar(List<Pagamento> pagamentos) {
		if (!pagamentos.isEmpty()) {
			System.out.println("Imóvel \t Data Pagamento \t Valor Fatura \t Valor Pagamento \t Fatura Quitada");
			System.out.println("--------------------------------------------------------------------");
			
			for (Pagamento pagamento : pagamentos) {
				System.out.println(pagamento.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}

}
