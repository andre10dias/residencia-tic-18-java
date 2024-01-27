package Controller;

import java.util.List;
import java.util.Scanner;

import Models.Imovel;
import Services.ImovelService;

public class ImovelController {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void cadastrarImovel() {
		System.out.println("\n======================== Cadastrar imóvel ========================");
		
		System.out.print("\nMatrícula: ");
		String matricula = entrada.nextLine();
		
		System.out.print("\nEndereço: ");
		String endereco = entrada.nextLine();
		
		Imovel imovel = new Imovel(matricula, endereco);
		ImovelService.addImovel(imovel);
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
				ImovelService.removeImovel(imovel);
				System.out.println("Imóvel removido com sucesso!");
				return;
			}
			else {
				System.out.println("Imóvel não encontrado!");
			}
		}
	}
	
}
