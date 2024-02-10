package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import menu.Menu;
import models.Fatura;
import models.Pagamento;
import models.Reembolso;
import services.FaturaService;
import services.ReembolsoService;

public class ReembolsoController {
	
	public static void realizarReembolso(Pagamento pagamento, double valorTodosPagamentos) {
		double valorReembolso = ReembolsoService.reembolsar(pagamento, valorTodosPagamentos);
		System.out.print("\nEste pagamento gerou um reembolso no valor de: " + valorReembolso);
	}

	public static void listarTodos() {
		List<Reembolso> reembolsos = ReembolsoService.getReembolsos();
		System.out.println("\n======================== Listar reembolsos ========================\n");
		
		listar(reembolsos);
	}

	public static void consultarReembolsoFatura() {
		Set<Fatura> faturas = new HashSet<>(FaturaService.getFaturas());
		System.out.println("\n======================== Listar reembolsos da fatura ========================\n");
		Fatura fatura = Menu.menuSelecionarFatura(new ArrayList<Fatura>(faturas));
		
		List<Reembolso> reembolsos = ReembolsoService.getReembolsosByFatura(fatura);
		listar(reembolsos);
	}
	
	private static void listar(List<Reembolso> reembolsos) {
		if (!reembolsos.isEmpty()) {
			System.out.println("Data Reembolso \t Valor Fatura \t Valor Pagamento \t Valor Reembolso");
			System.out.println("--------------------------------------------------------------------");
			
			for (Reembolso reembolso : reembolsos) {
				System.out.println(reembolso.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}
}
