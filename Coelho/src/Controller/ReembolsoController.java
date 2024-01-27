package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Menu.Menu;
import Models.Fatura;
import Models.Pagamento;
import Models.Reembolso;
import Services.FaturaService;
import Services.ReembolsoService;

public class ReembolsoController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void realizarReembolso(Pagamento pagamento, double valorTodosPagamentos) {
		Reembolso reembolso = new Reembolso(pagamento, valorTodosPagamentos);
		System.out.print("\nEste pagamento gerou um reembolso no valor de: " + reembolso.getValor());
		ReembolsoService.addReembolso(reembolso);
	}

	public static void listarTodos() {
		System.out.println("\n======================== Listar reembolsos ========================\n");
		List<Reembolso> reembolsos = ReembolsoService.getReembolsos();
		listar(reembolsos);
	}

	public static void consultarReembolsoFatura() {
		System.out.println("\n======================== Listar reembolsos da fatura ========================\n");
		Set<Fatura> faturas = new HashSet<>(FaturaService.getFaturas());
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
