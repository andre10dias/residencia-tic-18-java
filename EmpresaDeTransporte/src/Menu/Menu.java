package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.PassageiroController;
import Model.Passageiro;
import Util.MenuUtil;

public class Menu {
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastros básicos", "[ 2 ] Jornada", "[ 0 ] Sair"));
		int opcao = -1;
		
		do {
			if (opcao != 0) {				
				MenuUtil.montaMenu(itens, "Empresa de Transporte");
				opcao = MenuUtil.obterOpcao(itens.size());
				
				switch (opcao) {
				case 1:
					menuCadastrosBasicos();
					opcao = 0;
					break;
					
				case 2:
					menuJornada();
					opcao = 0;
					break;
					
				case 0:
					System.out.println("\nFinalizando programa...");
					break;
					
				default:
					break;
				}
			}
		} while (opcao != 0);
	}
	
	public static void menuCadastrosBasicos() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Passageiros", "[ 2 ] Motorista/Cobrador", "[ 3 ] Veiculos", 
				"[ 4 ] Pontos de parada", "[ 5 ] Trechos", "[ 6 ] Trajetos", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu cadastros básicos");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					menuPassageiros();
					break;
					
				case 2:
//					FaturaController.listarFaturas(false);
					break;
					
				case 3:
//					FaturaController.listarFaturas(true);
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}

	public static void menuJornada() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Iniciar jornada", "[ 2 ] Embarcar passageiro", "[ 3 ] Desembarcar passageiro", 
				"[ 1 ] Checkpoint", "[ 2 ] Finalizar jornada", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu jornada");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
//					ClienteController.cadastrarCliente();
					break;
					
				case 2:
//					ClienteController.listarClientes();
					break;

				case 3:
//					ClienteController.removerCliente();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static void menuPassageiros() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Cadastrar", "[ 2 ] Editar", "[ 3 ] Listar", "[ 4 ] Remover", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu passageiros");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					PassageiroController.cadastrarPassageiro();
					opcao = 0;
					break;
					
				case 2:
					PassageiroController.editarPassageiro();
					opcao = 0;
					break;
				
				case 3:
					PassageiroController.listar();
					opcao = 0;
					break;
					
				case 4:
					PassageiroController.removerPassageiro();
					opcao = 0;
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static void menuPagamento() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Realizar pagamento", "[ 2 ] Listar todos os pagamentos", "[ 3 ] Consultar pagamento de fatura", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu Fatura");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
//					PagamentoController.realizarPagamento();
					break;
					
				case 2:
//					PagamentoController.listarTodos();
					break;
					
				case 3:
//					PagamentoController.consultarPagFatura();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	private static void menuReembolso() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Listar todos os reembolsos", "[ 2 ] Consultar reembolsos da fatura", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu Reembolso");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
//					ReembolsoController.listarTodos();
					break;
					
				case 2:
//					ReembolsoController.consultarReembolsoFatura();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static Integer menuSelecionarPassageiro(List<Passageiro> listaPassageiros) {
		Integer indice = null;
		
		if (!listaPassageiros.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < listaPassageiros.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + listaPassageiros.get(i).getNome()  
						+ "\t" +  listaPassageiros.get(i).getNumeroCartao());
			}
			
			System.out.println("Passageiros cadastrados:\n");
			System.out.println("\tNome \t Número cartão");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			indice = opcao-1;
		}
		
		return indice;
	}
//	
//	public static Imovel menuSelecionarImovel(List<Imovel> imoveis) {
//		Imovel imovel = null;
//		
//		if (!imoveis.isEmpty()) {			
//			List<String> itensMenu = new ArrayList<>();
//			int opcao;
//			
//			for (int i = 0; i < imoveis.size(); i++) {
//				itensMenu.add("[ " + (i+1) + " ] " + imoveis.get(i).getMatricula());
//			}
//			
//			System.out.println("\nMatrículas dos imíveis cadastrados:");
//			MenuUtil.montaMenu(itensMenu, "");
//			opcao = MenuUtil.obterOpcao(itensMenu.size());
//			
//			imovel = imoveis.get(opcao-1);
//		}
//		
//		return imovel;
//	}
//	
//	public static Fatura menuSelecionarFatura(List<Fatura> faturas) {
//		Fatura fatura = null;
//		
//		if (!faturas.isEmpty()) {			
//			List<String> itensMenu = new ArrayList<>();
//			int opcao;
//			
//			for (int i = 0; i < faturas.size(); i++) {
//				itensMenu.add("[ " + (i+1) + " ] " + faturas.get(i).getDataEmissao() 
//						+ "\t" + faturas.get(i).getValorCalculado() + "\t" + faturas.get(i).isQuitada());
//			}
//			
//			System.out.println("Faturas em aberto:");
//			System.out.println("Data Emissão \t Valor \t\t Quitada");
//			MenuUtil.montaMenu(itensMenu, "");
//			opcao = MenuUtil.obterOpcao(itensMenu.size());
//			
//			fatura = faturas.get(opcao-1);
//		}
//		
//		return fatura;
//	}
	
}
