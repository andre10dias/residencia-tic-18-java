package Conversor;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String temperatura, opcao;
		ConversorTemperatura conversor = new ConversorTemperatura();
		
		System.out.println("\nSelecione uma opção: ");
		System.out.println("[ 1 ] Celsius para Fahrenheit");
		System.out.println("[ 2 ] Fahrenheit para Celsius");
		
		System.out.print("\nOpcao: ");
		opcao = entrada.nextLine();

		System.out.print("\nInforme a temperatura: ");
		temperatura = entrada.nextLine();
		
		System.out.println("");
		
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
			  System.out.println("Opção inválida.");
			  break;
		}
	}

}
