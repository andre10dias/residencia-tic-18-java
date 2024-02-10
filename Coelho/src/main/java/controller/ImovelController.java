package controller;

import java.util.List;
import java.util.Scanner;

import menu.Menu;
import models.Cliente;
import models.Imovel;
import services.ClienteService;
import services.ImovelService;

public class ImovelController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarImovel() {
		
		if (!ClienteService.getClientes().isEmpty()) {			
			System.out.println("\n======================== Cadastrar imóvel ========================");
			
			System.out.print("\nMatrícula: ");
			String matricula = entrada.nextLine();
			
			System.out.print("\nEndereço: ");
			String endereco = entrada.nextLine();
			
			Cliente cliente = Menu.menuSelecionarCliente();
			
			Imovel imovel = new Imovel(matricula, endereco, cliente);
			ImovelService.salvarImovel(imovel);
		}
		else {
			System.err.println("\\nRealize o cadastro de clientes.");
		}
	}
	
	public static void listarImoveis() {
		System.out.println("\n======================== Listar imóvel ========================\n");
		
		List<Imovel> imoveis = ImovelService.getImoveis();
		if (!imoveis.isEmpty()) {
			System.out.println("Matrícula \t Endereço");
			System.out.println("-----------------------");
			
			for (Imovel imovel : imoveis) {
				System.out.println(imovel.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}

	public static void removerImovel() {
		System.out.println("\n======================== Remover imóvel ========================\n");
		System.out.print("\nDigite a matrícula do imóvel que deseja remover: ");
		String matricula = entrada.nextLine();
		for (Imovel imovel : ImovelService.getImoveis()) {
			if (imovel.getMatricula().equals(matricula)) {
				ImovelService.removerImovel(imovel);
				System.out.println("Imóvel removido com sucesso!");
				return;
			}
			else {
				System.out.println("Imóvel não encontrado!");
			}
		}
	}
	
}
