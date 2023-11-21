package JogoAdivinhacao;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdivinhacao {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		boolean encerrarPrograma = false, numeroInvalido;
		String valor;
		Random r = new Random();
		int numRandom = r.nextInt(99) + 1;
		
		do {
			do {
				numeroInvalido = false;
				
				System.out.print("\nInforme um número entre 1 e 100: ");
				valor = entrada.nextLine();
				
				valor = valor.trim() != "" ? valor : "0";
				
				for (int i = 0; i < valor.length(); i++) {
					if (!Character.isDigit(valor.charAt(i))) {
						System.out.println("\nValor inválido.");
						numeroInvalido = true;
					}
				}
				
				if (!numeroInvalido && (Integer.parseInt(valor) < 1 
						|| Integer.parseInt(valor) > 100)) {
					System.out.println("\nValor inválido.");
					numeroInvalido = true;
				}
			} while(numeroInvalido);
			
			
			if (!numeroInvalido) {
				int num = Integer.parseInt(valor);
				
				if (num > numRandom) {
					System.out.println("Muito alto.");
				}
				else if (num < numRandom) {
					System.out.println("Muito baixo.");
				}
				else {
					System.out.println("Acertou!");
					encerrarPrograma = true;
				}
			}
		} while(!encerrarPrograma);
	}

}
