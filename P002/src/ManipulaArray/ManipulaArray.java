package ManipulaArray;

import java.util.Random;
import java.util.Scanner;

public class ManipulaArray {
	
	private static final int TAMANHO_ARRAY = 5;
	
	private int[] array;
	
	public ManipulaArray() {
		array = new int[TAMANHO_ARRAY];
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void gerarArray() {
		Scanner entrada = new Scanner(System.in);
		boolean numeroInvalido;
		
		System.out.println("Informe " + array.length + " números inteiros: ");
		for (int i = 0; i < array.length; i++) {
			do {
				numeroInvalido = false;
				String valor = entrada.nextLine();
				
				numeroInvalido = valor.trim() == "" ? true : false;
				
				for (int j = 0; j < valor.length(); j++) {
					if (!Character.isDigit(valor.charAt(j))) {
						numeroInvalido = true;
						break;
					}
				}
				
				if (!numeroInvalido) {
					array[i] = Integer.parseInt(valor);
				}
				else {
					System.out.println("\nNúmero inválido.");
				}
			} while(numeroInvalido);
		}
	}
	
	public void gerarArrayAleatorio() {
		Random r = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int numRandom = r.nextInt(99) + 1;
			array[i] = numRandom;
		}
	}
	
	public int maiorValorArray() {
		int maior = -1;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		
		return maior;
	}
	
	public int menorValorArray() {
		int menor = 1000;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] < menor) {
				menor = array[i];
			}
		}
		
		return menor;
	}
	
	public void imprimeArray() {
		System.out.print("Array = [ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.print("]\n");
	}

}
