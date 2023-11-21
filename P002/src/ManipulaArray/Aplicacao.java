package ManipulaArray;

public class Aplicacao {

	public static void main(String[] args) {
		ManipulaArray manipula = new ManipulaArray();
		
		manipula.gerarArray();
		System.out.println("\nElementos inserido pelo usuário: ");
		manipula.imprimeArray();
		
		manipula.gerarArrayAleatorio();
		System.out.println("\nElementos gerados aleatóriamente: ");
		manipula.imprimeArray();
		
		System.out.println("\nMaior valor do array: " + manipula.maiorValorArray());
		System.out.println("Menor valor do array: " + manipula.menorValorArray());

	}

}
