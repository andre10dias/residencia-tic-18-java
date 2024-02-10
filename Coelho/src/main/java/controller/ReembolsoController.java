package controller;

import java.sql.SQLException;
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
		try {
			double valorReembolso = ReembolsoService.reembolsar(pagamento, valorTodosPagamentos);
			System.out.print("\nEste pagamento gerou um reembolso no valor de: " + valorReembolso);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void listarTodos() {
		System.out.println("\n======================== Listar reembolsos ========================\n");
		
		try {
			List<Reembolso> reembolsos = ReembolsoService.getReembolsos();
			listar(reembolsos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void consultarReembolsoFatura() {
		System.out.println("\n======================== Listar reembolsos da fatura ========================\n");
		Set<Fatura> faturas = new HashSet<>(FaturaService.getFaturas());
		Fatura fatura = Menu.menuSelecionarFatura(new ArrayList<Fatura>(faturas));
		
		try {
			List<Reembolso> reembolsos = ReembolsoService.getReembolsosByFatura(fatura);
			listar(reembolsos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
