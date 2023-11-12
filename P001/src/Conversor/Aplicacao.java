package Conversor;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String temperatura = "", opcao;
		boolean opcaoInvalida, encerrarPrograma;
		ConversorTemperatura conversor = new ConversorTemperatura();
		
		do {
			encerrarPrograma = false;
			opcaoInvalida = false;
			
			System.out.println("\nSelecione uma opção: ");
			System.out.println("[ 1 ] Celsius para Fahrenheit");
			System.out.println("[ 2 ] Fahrenheit para Celsius");
			
			System.out.print("\nOpcao: ");
			opcao = entrada.nextLine();
			
			if (Character.isDigit(opcao.charAt(0)) 
					&& (Integer.parseInt(opcao) == 1 || Integer.parseInt(opcao) == 2)) {
				
				System.out.print("\nInforme a temperatura: ");
				temperatura = entrada.nextLine();
				
				temperatura = temperatura == "".trim() ? temperatura = "0" : temperatura; 
			}
			
			switch(opcao) {
			  case "1":
				  double f = conversor.converterCelsiusParaFahrenheit(Double.parseDouble(temperatura));
				  System.out.println(temperatura + "°C = "  + String.format("%.2f", f) + "°F");
				  break;
			  case "2":
				  double c = conversor.converterFahrenheitParaCelsius(Double.parseDouble(temperatura));
				  System.out.println(temperatura + "°F = " + String.format("%.2f", c) + "°C");
				  break; 
			  default:
				  System.out.println("\nOpção inválida.");
				  opcaoInvalida = true;
				  break;
			}
			
			if (!encerrarPrograma && !opcaoInvalida) {
				do {	
					opcaoInvalida = false;
					
					System.out.println("\nDeseja realizar um novo cálculo?");
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
