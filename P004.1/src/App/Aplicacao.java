package App;

import java.util.ArrayList;
import java.util.List;

import Exception.DivisionByZeroException;
import Service.Calculadora;

public class Aplicacao {

	public static void main(String[] args) {
		
		System.out.println("Soma ponto flutuante: ");
		Calculadora.imprimeSoma(3.1f, 2f);
		
		System.out.println("\nSoma inteiro: ");
		Calculadora.imprimeSoma(3, 2);
		
		System.out.println("\nSubtração ponto flutuante: ");
		Calculadora.imprimeSubtracao(3.1f, 2f);
		
		System.out.println("\nSubtração inteiro: ");
		Calculadora.imprimeSubtracao(3, 2);
		
		System.out.println("\nMultiplicação ponto flutuante: ");
		Calculadora.imprimeMultiplicacao(3.1f, 2f);
		
		System.out.println("\nMultiplicação inteiro: ");
		Calculadora.imprimeMultiplicacao(3, 2);
		
		System.out.println("\nDivisão ponto flutuante: ");
		try {
			Calculadora.imprimeDivisao(3.1f, 2f);
		} catch (DivisionByZeroException e) {
			e.getMessage();
		}
		
		System.out.println("\nDivisão inteiro: ");
		try {
			Calculadora.imprimeDivisao(3, 2);
		} catch (DivisionByZeroException e) {
			e.getMessage();
		}
		
		System.out.println("\nOperações em sequência: ");
		List<Float> numeros = new ArrayList<>();
		numeros.add(2.1f);
		numeros.add(3.4f);
		numeros.add(1.0f);
		numeros.add(.7f);
		numeros.add(4.4f);
		numeros.add(1.1f);
		
		try {			
			Calculadora.imprimeOperacoes(numeros, "+");
			Calculadora.imprimeOperacoes(numeros, "-");
			Calculadora.imprimeOperacoes(numeros, "*");
			Calculadora.imprimeOperacoes(numeros, "/");
		} catch (DivisionByZeroException e) {
			System.out.println(e.getMessage());
		}

	}

}
