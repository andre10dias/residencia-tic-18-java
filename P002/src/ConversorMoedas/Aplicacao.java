package ConversorMoedas;

import java.text.NumberFormat;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String taxa, valor, opcao;
		boolean encerrarPrograma, opcaoInvalida;
		
		do {
			encerrarPrograma = false;
			
			System.out.println("\nInforme a taxa de câmbio: ");
			taxa = entrada.nextLine();
			
			System.out.println("\nInforme o valor em dólar: ");
			valor = entrada.nextLine();
			
			taxa = valor.replace(",", ".");
			valor = valor.replace(",", ".");
			
			ConversorDeMoedas conversor = new ConversorDeMoedas(Double.parseDouble(taxa), 
					Double.parseDouble(valor));
			
			NumberFormat nf = NumberFormat.getCurrencyInstance();
		    String valorFormatado = nf.format(conversor.converte());
		    
			System.out.println("\nValor convertido: " + valorFormatado);
			
			if (!encerrarPrograma) {
				do {	
					opcaoInvalida = false;
					
					System.out.println("\nDeseja realizar uma nova conversão?");
					System.out.println("[ 1 ] Sim\t[ 2 ] Não");
					System.out.print("\nOpção: ");
					opcao = entrada.nextLine();
					
					if (Character.isDigit(opcao.charAt(0)) 
							&& (Integer.parseInt(opcao) < 1 || Integer.parseInt(opcao) > 2)) {
						
						System.out.println("\nOpção inválida.");
						opcaoInvalida = true;
					}
					else if (opcao.equals("2")) {
						System.out.println("\nFinalizando programa...");
						encerrarPrograma = true;
					}
					
					System.out.println("");
				} while(opcaoInvalida);
			}
		} while(!encerrarPrograma);
	}

}
