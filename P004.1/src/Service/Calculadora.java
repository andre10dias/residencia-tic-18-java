package Service;

import java.util.List;

import Exception.DivisionByZeroException;
import Util.Util;

public class Calculadora {
	
	public static void imprimeSoma(Integer a, Integer b) {
		System.out.println(a + " + " + b + " = " + soma(a, b));
	}
	
	public static void imprimeSoma(Float a, Float b) {
		Float resultado = soma(a, b);
		System.out.println(a + " + " + b + " = " + Util.formatNumber(resultado));
	}
	
	public static void imprimeSubtracao(Integer a, Integer b) {
		System.out.println(a + " - " + b + " = " + subtracao(a, b));
	}
	
	public static void imprimeSubtracao(Float a, Float b) {
		Float resultado = subtracao(a, b);
		System.out.println(a + " - " + b + " = " + Util.formatNumber(resultado));
	}
	
	public static void imprimeMultiplicacao(Integer a, Integer b) {
		System.out.println(a + " * " + b + " = " + multiplicacao(a, b));
	}
	
	public static void imprimeMultiplicacao(Float a, Float b) {
		Float resultado = multiplicacao(a, b);
		System.out.println(a + " * " + b + " = " + Util.formatNumber(resultado));
	}
	
	public static void imprimeDivisao(Integer a, Integer b) throws DivisionByZeroException {
		System.out.println(a + " / " + b + " = " + divisao(a, b));
	}
	
	public static void imprimeDivisao(Float a, Float b) throws DivisionByZeroException {
		Float resultado = divisao(a, b);
		System.out.println(a + " / " + b + " = " + Util.formatNumber(resultado));
	}
	
	public static void imprimeOperacoes(List<Float> numeros, String operacao) throws DivisionByZeroException {
		switch (operacao) {
		case "+":
			imprimeOperacaoSoma(numeros);
			break;

		case "-":
			imprimeOperacaoSubtracao(numeros);
			break;
			
		case "*":
			imprimeOperacaoMultiplicacao(numeros);
			break;

		case "/":
			imprimeOperacaoDivisao(numeros);
			break;
		}
	}
	
	private static void imprimeOperacaoSoma(List<Float> numeros) {
		Float resultado = numeros.get(0);
		
		for (int i = 1; i < numeros.size(); i++) {
			resultado += numeros.get(i);
			
			System.out.print(numeros.get(i));
			if (i < numeros.size()-1) {
				System.out.print(" + ");
			}
			else {
				System.out.println(" = " + Util.formatNumber(resultado));
			}
		}
	}
	
	private static void imprimeOperacaoSubtracao(List<Float> numeros) {
		Float resultado = numeros.get(0);
		
		for (int i = 1; i < numeros.size(); i++) {
			resultado -= numeros.get(i);
			
			System.out.print(numeros.get(i));
			if (i < numeros.size()-1) {
				System.out.print(" - ");
			}
			else {
				System.out.println(" = " + Util.formatNumber(resultado));
			}
		}
	}
	
	private static void imprimeOperacaoMultiplicacao(List<Float> numeros) {
		Float resultado = numeros.get(0);
		
		for (int i = 1; i < numeros.size(); i++) {
			resultado *= numeros.get(i);
			
			System.out.print(numeros.get(i));
			if (i < numeros.size()-1) {
				System.out.print(" * ");
			}
			else {
				System.out.println(" = " + Util.formatNumber(resultado));
			}
		}
	}
	
	private static void imprimeOperacaoDivisao(List<Float> numeros) throws DivisionByZeroException {
		Float resultado = numeros.get(0);
		
		for (int i = 1; i < numeros.size(); i++) {
			if (i > 0 && numeros.get(i) == 0) {
				throw new DivisionByZeroException();
			}
			
			resultado /= numeros.get(i);
			
			System.out.print(numeros.get(i));
			if (i < numeros.size()-1) {
				System.out.print(" / ");
			}
			else {
				System.out.println(" = " + Util.formatNumber(resultado));
			}
		}
	}
	
	private static Integer soma(Integer a, Integer b) {
		return a + b;
	}
	
	private static Float soma(Float a, Float b) {
		return a + b;
	}
	
	private static Integer subtracao(Integer a, Integer b) {
		return a - b;
	}
	
	private static Float subtracao(Float a, Float b) {
		return a - b;
	}
	
	private static Integer multiplicacao(Integer a, Integer b) {
		return a * b;
	}
	
	private static Float multiplicacao(Float a, Float b) {
		return a * b;
	}
	
	public static Integer divisao(Integer a, Integer b) throws DivisionByZeroException {
		if (b == 0) {
			throw new DivisionByZeroException();
		}
		
		return a / b;
	}
	
	public static Float divisao(Float a, Float b) throws DivisionByZeroException {
		if (b == 0) {
			throw new DivisionByZeroException();
		}
		
		return a / b;
	}

}
