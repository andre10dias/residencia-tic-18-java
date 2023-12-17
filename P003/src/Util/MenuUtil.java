package Util;

import java.util.List;
import java.util.Scanner;

public class MenuUtil {
	
	public static void montaMenu(List<String> itens, String titulo) {
		if (titulo != "") {			
			System.out.println("\n======================== " + titulo + " ========================\n");
		}
	    
	    for (String item : itens) {
			System.out.println(item);
		}
	}

	public static int obterOpcao(Scanner entrada, int qtdeOpcoes)
	{
	    int opcao = -1;
	    while ((opcao < 0) || (opcao > qtdeOpcoes))
	    {
	    	System.out.print("\nSelecione uma opção: ");
	    	opcao = Util.stringToInt(entrada.nextLine());
	    	
	        if ((opcao < 0) || (opcao > qtdeOpcoes)) {
	        	System.out.println("Opção inválida.");
	        }
	    }
	    
	    return opcao;
	}

}
