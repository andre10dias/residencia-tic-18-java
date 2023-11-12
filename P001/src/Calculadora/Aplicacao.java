package Calculadora;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String a, b, operacao;
		boolean opcaoInvalida, encerrarPrograma;
		Calculadora calculadora = new Calculadora();
		
		do {
			encerrarPrograma = false;
			
			System.out.print("Informe o valor do primeiro termo: ");
			a = entrada.nextLine();
			
			System.out.print("Informe o valor do segundo termo: ");
			b = entrada.nextLine();
			
			a = a == "".trim() ? a = "0" : a; 
			b = b == "".trim() ? b = "0" : b; 
			
			do {
				opcaoInvalida = false;
				
				System.out.println("\nSelecione a operação: ");
				System.out.println("[ 1 ] Soma\t[ 2 ] Subtração");
				System.out.println("[ 3 ] Divisão\t[ 4 ] Multiplicação");
				System.out.println("[ 0 ] Sair");
				
				System.out.print("\nOperação: ");
				operacao = entrada.nextLine();
				
				System.out.println("");
				
				switch(operacao) {
				  case "0":
					  System.out.println("\nFinalizando programa...");
					  encerrarPrograma = true;
					  break;
				  case "1":
					  int soma = calculadora.soma(Integer.parseInt(a), Integer.parseInt(b));
					  System.out.println(a + " + " + b + " = " + soma);
					  break;
				  case "2":
					  int subtracao = calculadora.subtracao(Integer.parseInt(a), Integer.parseInt(b));
					  System.out.println(a + " - " + b + " = " + subtracao);
					  break;
				  case "3":
					  int divisao = calculadora.divisao(Integer.parseInt(a), Integer.parseInt(b));
					  System.out.println(a + " / " + b + " = " + divisao);
					  break;
				  case "4":
					  int multiplicacao = calculadora.multiplicacao(Integer.parseInt(a), Integer.parseInt(b));
					  System.out.println(a + " * " + b + " = " + multiplicacao);
					  break; 
				  default:
					  System.out.println("\nOpção inválida.");
					  opcaoInvalida = true;
					  break;
				}
				
				if (!encerrarPrograma && !opcaoInvalida) {
					String opcao = "";
					
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
				
			} while(opcaoInvalida);
			
		} while(!encerrarPrograma);
	}
	
}
