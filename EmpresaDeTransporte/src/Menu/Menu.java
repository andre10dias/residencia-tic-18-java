package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controller.MotoristaCobradorController;
import Controller.PassageiroController;
import Controller.PontoParadaController;
import Controller.TrajetoController;
import Controller.TrechoController;
import Controller.VeiculoController;
import Util.MenuUtil;

public class Menu {
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Cadastros básicos", "[ 2 ] Jornada", "[ 0 ] Sair"));
		int opcao = -1;
		
		do {
			if (opcao != 0) {				
				MenuUtil.montaMenu(itens, "Empresa de Transporte", "");
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
			MenuUtil.montaMenu(itens, "Menu cadastros básicos", "");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					MenuUtil.menuController(PassageiroController.getInstance());
					opcao = 0;
					break;
					
				case 2:
					MenuUtil.menuController(MotoristaCobradorController.getInstance());
					opcao = 0;
					break;
					
				case 3:
					MenuUtil.menuController(VeiculoController.getInstance());
					opcao = 0;
					break;
					
				case 4:
					MenuUtil.menuController(PontoParadaController.getInstance());
					opcao = 0;
					break;
					
				case 5:
					MenuUtil.menuController(TrechoController.getInstance());
					opcao = 0;
					break;
					
				case 6:
					MenuUtil.menuController(TrajetoController.getInstance());
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

	public static void menuJornada() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Iniciar jornada", "[ 2 ] Embarcar passageiro", "[ 3 ] Desembarcar passageiro", 
				"[ 1 ] Checkpoint", "[ 2 ] Finalizar jornada", "[ 0 ] Sair"
		));
		int opcao;
		
		do {
			MenuUtil.montaMenu(itens, "Menu jornada", "Ainda não implementado.");
			opcao = MenuUtil.obterOpcao(itens.size());
			
			switch (opcao) {
				case 1:
					System.out.println("Ainda não implementado.");
					break;
					
				case 2:
					System.out.println("Ainda não implementado.");
					break;

				case 3:
					System.out.println("Ainda não implementado.");
					break;
					
				case 0:
					menuPrincipal();
					break;
	
				default:
					break;
			}
		} while (opcao != 0);
	}
	
}
