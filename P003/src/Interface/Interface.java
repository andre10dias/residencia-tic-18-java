package Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Exception.DivisionByZeroException;
import Service.Calculadora;
import Util.MenuUtil;
import Util.Util;

public class Interface {
	
	private static Scanner entrada = new Scanner(System.in);
	
	public static void menuPrincipal() {
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Soma", 
				"[ 2 ] Subtração",
				"[ 3 ] Multiplicação", 
				"[ 4 ] Divisão",
				"[ 0 ] Sair"
		));
		Integer opcao = -1;
		String vl1 = null;
		String vl2 = null;
		
		do {
			if (opcao != 0) {				
				MenuUtil.montaMenu(itens, "Calculadora");
				opcao = MenuUtil.obterOpcao(entrada, itens.size());
				
				if (opcao > 0 && opcao < itens.size()) {					
					System.out.print("\nInforme o primeiro valor: ");
					vl1 = entrada.nextLine();
					
					System.out.print("Informe o segundo valor: ");
					vl2 = entrada.nextLine();
					
					vl1 = vl1.replace(",", ".");
					vl2 = vl2.replace(",", ".");
					
					System.out.println("\n");
				}
				
				if (vl1 == null || vl2 == null 
						|| (vl1 != null && vl2 != null && vl1.trim() != "" && vl2.trim() != "")) {
					switch (opcao) {
					case 1:
						Calculadora.soma(Util.stringToFloat(vl1), Util.stringToFloat(vl2));
						novoCalculo();
						opcao = 0;
						break;
						
					case 2:
						Calculadora.subtracao(Util.stringToFloat(vl1), Util.stringToFloat(vl2));
						novoCalculo();
						opcao = 0;
						break;
						
					case 3:
						Calculadora.multiplicacao(Util.stringToFloat(vl1), Util.stringToFloat(vl2));
						novoCalculo();
						opcao = 0;
						break;
						
					case 4:
						try {							
							Calculadora.divisao(Util.stringToFloat(vl1), Util.stringToFloat(vl2));
						} catch (DivisionByZeroException e) {
							System.out.println(e.getMessage());
						} finally {							
							novoCalculo();
							opcao = 0;
						}
						break;
						
					case 0:
						System.out.println("\nFinalizando programa...");
						opcao = 0;
						break;
						
					default:
						System.out.println("\nOpção inválida.");
						break;
					}
					
					
				}
				else {
					System.out.println("Opção inválida.");
				}
			}
		} while (opcao != 0);
	}
	
	public static void novoCalculo() {
		System.out.println("\n\nDeseja realizar um novo calculo?");
		List<String> itens = new ArrayList<>(Arrays.asList(
				"[ 1 ] Sim", 
				"[ 0 ] Não"
		));
		int opcao = -1;
		
		do {
			if (opcao != 0) {				
				MenuUtil.montaMenu(itens, "");
				opcao = MenuUtil.obterOpcao(entrada, itens.size());
				
				switch (opcao) {
				case 1:
					menuPrincipal();
					opcao = 0;
					break;
					
				case 0:
					System.out.println("\nFinalizando programa...");
					opcao = 0;
					break;
					
				default:
					break;
				}
			}
		} while (opcao != 0);
	}

}
