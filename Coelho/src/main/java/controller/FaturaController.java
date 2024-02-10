package controller;

import java.util.List;
import java.util.Scanner;

import Utils.Util;
import menu.Menu;
import models.Cliente;
import models.Fatura;
import models.Imovel;
import services.ClienteService;
import services.FaturaService;
import services.ImovelService;

public class FaturaController {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void realizarLeitura() {
		System.out.println("\n======================== Realizar leiruta do imóvel ========================");
		
		Imovel imovelSelecionado = Menu.menuSelecionarImovel(ImovelService.getImoveisComClientes());
		
		if (imovelSelecionado != null) {			
			System.out.print("\nValor da leitura: ");
			Double leitura = Util.stringToDouble(entrada.nextLine());
			
			Fatura fatura = FaturaService.registraLeitura(imovelSelecionado, leitura);
			
			System.out.println("\nImprimindo fatura...\n");
			imprimeFatura(fatura);
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}
	
	public static void listarFaturas(boolean isQuitada) {
		String titulo = isQuitada ? "quitadas" : "";
		System.out.println("\n======================== Listar faturas " + titulo +" ========================\n");
		
		List<Fatura> faturas = isQuitada ? FaturaService.getFaturasQuitadas() : FaturaService.getFaturas();
		if (!faturas.isEmpty()) {
			System.out.println("Imóvel \t\t Data Emissão \t Consumo \t Valor \t Quitada");
			System.out.println("-----------------------------------------------------------------");
			
			for (Fatura fatura : faturas) {
				System.out.println(fatura.toString());
			}
		}
		else {
			System.out.println("\nNão existem dados para serem exibidos.");
		}
	}
	
	private static void imprimeFatura(Fatura fatura) {
		Imovel imovel = fatura.getImovel();
		Cliente cliente = ClienteService.getClienteByImovel(imovel);
		
		System.out.println("====================================================");
		System.out.println("| COELHO -  COmpalhia ELétrica de Hoje e Ontem Ltda");
		System.out.println("|");
		System.out.println("|");
		System.out.println("| Inscrição: " + imovel.getMatricula());
		System.out.println("| Nome do Responsável: " + cliente.getNome());
		System.out.println("| Endereço: " + imovel.getEndereco());
		System.out.println("|");
		System.out.println("|");
		System.out.println("| Data Emissão: " + fatura.getDataEmissaoFormatada());
		System.out.println("| Valor: " + fatura.getValorCalculado());
		System.out.println("|");
		System.out.println("|");
		System.out.println("====================================================");
	}

}
