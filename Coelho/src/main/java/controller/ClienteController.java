package controller;

import java.util.List;
import java.util.Scanner;

import Utils.Util;
import models.Cliente;
import models.Imovel;
import services.ClienteService;

public class ClienteController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarCliente() {		
		System.out.println("\n======================== Cadastrar cliente ========================");
		
//		if (!ImovelService.getImoveis().isEmpty()) {	
//			List<Imovel> imoveis = new ArrayList<>();
			
			System.out.print("\nNome: ");
			String nome = entrada.nextLine();
			
			System.out.print("\nCPF: ");
			String cpf = entrada.nextLine();
			
//			Imovel imovel = Menu.menuSelecionarImovel(ImovelService.getImoveis());
//			imoveis.add(imovel);
			
			Cliente cliente = new Cliente(nome, cpf);
			//cliente.setImoveis(imoveis);
			
			ClienteService.salvarCliente(cliente);
//		}
//		else {
//			System.out.println("\\nNão existem dados para serem exibidos.");
//		}
	}

	public static void removerCliente() {
		System.out.println("\n======================== Remover cliente ========================");
		List<Cliente> clientes = ClienteService.getClientes();

		if (!clientes.isEmpty()) {
			for (int i = 0; i < clientes.size(); i++) {
				System.out.println("[ " + (i + 1) + " ] " + clientes.get(i).getNome());
			}

			System.out.print("Qual cliente deseja selecionar? Escolha pelo número de cada um: ");
			int escolha = Util.stringToInt(entrada.nextLine());

			if (escolha >= 1 && escolha <= clientes.size()) {
				Cliente clienteSelecionado = clientes.get(escolha - 1);
				ClienteService.removerCliente(clienteSelecionado);
				System.out.println("Cliente removido com sucesso.");
			} else {
				System.out.println("Número de cliente inválido.");
			}
		} else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}
	
	
	public static void listarClientes() {
		System.out.println("\n======================== Listar cliente ========================\n");
		
		List<Cliente> clientes = ClienteService.getClientes();
		if (!clientes.isEmpty()) {
			System.out.println("CPF \t\t Nome");
			System.out.println("--------------------------");
			
			for (Cliente cliente : clientes) {
				System.out.println(cliente.toString());
			}
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}
	
	public static void listarImoveisDoClientes() {
		System.out.println("\n======================== Listar imóveis do cliente ========================\n");
		
		List<Cliente> clientesComImovel = ClienteService.retornaClientesComImovel();
		
		if (!clientesComImovel.isEmpty()) {
			for (Cliente cliente : clientesComImovel) {
				System.out.println("Cliente: " + cliente.getNome() + "\tCPF: " + cliente.getCpf());
				
				System.out.println("\nImóveis:");
				System.out.println("Matrícula \t Endereço");
				System.out.println("--------------------------");
				
				for (Imovel imovel : cliente.getImoveis()) {
					System.out.println(imovel.toString());
				}
				
				System.out.println();
			}
		}
		else {
			System.out.println("\\nNão existem dados para serem exibidos.");
		}
	}

}
