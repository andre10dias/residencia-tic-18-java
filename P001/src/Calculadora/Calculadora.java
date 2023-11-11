package Calculadora;

public class Calculadora {
	
	public Calculadora() {
		// TODO Auto-generated constructor stub
	}

	public int soma(int a, int b) {
		return a + b;
	}
	
	public int subtracao(int a, int b) {
		return a - b;
	}
	
	public int divisao(int a, int b) {
		if (b != 0) {			
			return a / b;
		}
		
		return 0;
	}
	
	public int multiplicacao(int a, int b) {
		return a * b;
	}

}
