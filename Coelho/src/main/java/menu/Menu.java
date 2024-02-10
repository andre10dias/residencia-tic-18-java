package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.MenuUtil;
import controller.ClienteController;
import controller.FaturaController;
import controller.ImovelController;
import controller.PagamentoController;
import controller.ReembolsoController;
import models.Cliente;
import models.Fatura;
import models.Imovel;
import services.ClienteService;
import services.FaturaService;
import services.ImovelService;

public class Menu {
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cliente", "[ 2 ] Imóvel"));
		int opcao = -1;
		
		if (!ImovelService.getImoveis().isEmpty() && !ClienteService.getClientes().isEmpty()) {
			itens.add("[ 3 ] Fatura");
		}
		
		if (!FaturaService.getFaturas().isEmpty()) {
			itens.add("[ 4 ] Pagamento");
			itens.add("[ 5 ] Reembolso");
		}
		
		itens.add("[ 0 ] Sair");
		
		do {
			if (opcao != 0) {				
				MenuUtil.montaMenu(itens, "Empresa de Distribuição de Energia COELHO");
				opcao = MenuUtil.obterOpcao(itens.size());
				
				switch (opcao) {
				case 1:
					menuCliente();
					opcao = 0;
					break;
					
				case 2:
					menuImovel();
					opcao = 0;
					break;
					
				case 3:
					menuFatura();
					opcao = 0;
					break;
					
				case 4:
					menuPagamento();
					opcao = 0;
					break;
					
				case 5:
					menuReembolso();
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

	public static void menuCliente() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar", "[ 3 ] Listar imóveis", 
				"[ 4 ] Remover", "[ 0 ] Sair"));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu Clientes");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					ClienteController.cadastrarCliente();
					break;
					
				case 2:
					ClienteController.listarClientes();
					break;
					
				case 3:
					ClienteController.listarImoveisDoClientes();
					break;

				case 4:
					ClienteController.removerCliente();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static void menuImovel() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastrar", "[ 2 ] Listar", "[ 3 ] Remover", "[ 0 ] Sair"));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu Imóveis");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					ImovelController.cadastrarImovel();
					break;
					
				case 2:
					ImovelController.listarImoveis();
					break;
				
				case 3:
					ImovelController.removerImovel();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static void menuFatura() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Realizar leitura", "[ 2 ] Listar todas ", "[ 3 ] Listar quitadas ", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu Fatura");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					FaturaController.realizarLeitura();
					break;
					
				case 2:
					FaturaController.listarFaturas(false);
					break;
					
				case 3:
					FaturaController.listarFaturas(true);
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
			MenuUtil.montaMenu(itens, "Menu Pagamento");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					PagamentoController.realizarPagamento();
					break;
					
				case 2:
					PagamentoController.listarTodos();
					break;
					
				case 3:
					PagamentoController.consultarPagFatura();
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
					ReembolsoController.listarTodos();
					break;
					
				case 2:
					ReembolsoController.consultarReembolsoFatura();
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
	public static Cliente menuSelecionarCliente() {
		List<Cliente> clientes = ClienteService.getClientes();
		Cliente cliente = null;
		
		if (!clientes.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < clientes.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + clientes.get(i).getCpf() + "\t" + clientes.get(i).getNome());
			}
			
			System.out.println("Clientes cadastrados:");
			System.out.println("\n\tNome \t\t CPF ");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			cliente = clientes.get(opcao-1);
		}
		
		return cliente;
	}
	
	public static Imovel menuSelecionarImovel(List<Imovel> imoveis) {
		Imovel imovel = null;
		
		if (!imoveis.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < imoveis.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + imoveis.get(i).getMatricula());
			}
			
			System.out.println("\nMatrículas dos imóveis cadastrados:");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			imovel = imoveis.get(opcao-1);
		}
		
		return imovel;
	}
	
	public static Fatura menuSelecionarFatura(List<Fatura> faturas) {
		Fatura fatura = null;
		
		if (!faturas.isEmpty()) {			
			List<String> itensMenu = new ArrayList<>();
			int opcao;
			
			for (int i = 0; i < faturas.size(); i++) {
				itensMenu.add("[ " + (i+1) + " ] " + faturas.get(i).getDataEmissaoFormatada() 
						+ "\t" + faturas.get(i).getValorCalculado() + "\t" + faturas.get(i).isQuitadaPorExtenso());
			}
			
			System.out.println("      Data Emissão \t Valor \t Quitada");
			MenuUtil.montaMenu(itensMenu, "");
			opcao = MenuUtil.obterOpcao(itensMenu.size());
			
			fatura = faturas.get(opcao-1);
		}
		
		return fatura;
	}
	
}
