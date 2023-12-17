package Service;

import Exception.DivisionByZeroException;
import Util.Util;

public class Calculadora {
	
	public static void soma(Float a, Float b) {
		imprimeSoma(a, b);
	}
	
	public static void subtracao(Float a, Float b) {
		imprimeSubtracao(a, b);
	}
	
	public static void multiplicacao(Float a, Float b) {
		imprimeMultiplicacao(a, b);
	}
	
	public static void divisao(Float a, Float b) throws DivisionByZeroException {
		imprimeDivisao(a, b);
	}
	
	private static void imprimeSoma(Integer a, Integer b) {
		System.out.print("Resultado: " + (a + b));
	}
	
	private static void imprimeSoma(Float a, Float b) {
		Float resultado = a + b;
		System.out.print("Resultado: " + Util.formatNumber(resultado));
	}
	
	private static void imprimeSubtracao(Integer a, Integer b) {
		System.out.print("Resultado: " + (a - b));
	}
	
	private static void imprimeSubtracao(Float a, Float b) {
		Float resultado = a - b;
		System.out.print("Resultado: " + Util.formatNumber(resultado));
	}
	
	private static void imprimeMultiplicacao(Integer a, Integer b) {
		System.out.print("Resultado: " + a * b);
	}
	
	private static void imprimeMultiplicacao(Float a, Float b) {
		Float resultado = a * b;
		System.out.print("Resultado: " + Util.formatNumber(resultado));
	}
	
	private static void imprimeDivisao(Integer a, Integer b) throws DivisionByZeroException {
		if (b == 0) {
			throw new DivisionByZeroException();
		}
		
		System.out.print("Resultado: " + a / b);
	}
	
	private static void imprimeDivisao(Float a, Float b) throws DivisionByZeroException {
		if (b == 0) {
			throw new DivisionByZeroException();
		}
		
		Float resultado = a / b;
		System.out.print("Resultado: " + Util.formatNumber(resultado));
	}

}
