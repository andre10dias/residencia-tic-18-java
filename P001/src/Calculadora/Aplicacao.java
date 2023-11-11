package Calculadora;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String a, b, operacao;
		Calculadora calculadora = new Calculadora();

		System.out.print("Informe o valor do primeiro termo: ");
		a = entrada.nextLine();
		
		System.out.print("Informe o valor do segundo termo: ");
		b = entrada.nextLine();
		
		System.out.println("\nSelecione a operação: ");
		System.out.println("[ 1 ] Soma\t[ 2 ] Subtração");
		System.out.println("[ 3 ] Divisão\t[ 4 ] Multiplicação");
		
		System.out.print("\nOperação: ");
		operacao = entrada.nextLine();
		
		System.out.println("");
		
		switch(operacao) {
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
			  System.out.println("Opção inválida.");
			  break;
		}
	}

}
