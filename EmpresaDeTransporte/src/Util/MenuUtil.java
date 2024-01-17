package Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controller.IController;
import Menu.Menu;

public class MenuUtil {
	
	private static Scanner entrada = new Scanner(System.in);

    public static <T> void menuController(IController<T> controller) {
        List<String> itens = new ArrayList<>(Arrays.asList(
                "[ 1 ] Cadastrar", "[ 2 ] Editar", "[ 3 ] Listar", "[ 4 ] Remover", "[ 0 ] Sair"
        ));
        int opcao;

        do {
            montaMenu(itens, "Menu " + controller.getNome(), "");
            opcao = obterOpcao(itens.size());

            switch (opcao) {
                case 1:
                    controller.cadastrar();
                    break;

                case 2:
                    controller.editar();
                    break;

                case 3:
                    controller.listar();
                    break;

                case 4:
                    controller.remover();
                    break;

                case 0:
                    Menu.menuCadastrosBasicos();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }
    
    public static <T> Integer menuSelecionarElemento(List<T> lista, List<String> nomesAtributos, String textoAdicional) {
        Integer indice = null;

        if (!lista.isEmpty()) {
            List<String> itensMenu = new ArrayList<>();
            int opcao;

            for (int i = 0; i < lista.size(); i++) {
                itensMenu.add("[ " + (i + 1) + " ] " + getAtributos(lista.get(i), nomesAtributos));
            }
            
            if (textoAdicional != null && textoAdicional != "") {				
            	System.out.println(textoAdicional);
			}
            
            System.out.println("Elementos cadastrados:\n");
            System.out.println("\t" + String.join("\t", nomesAtributos));
            montaMenu(itensMenu, "", "");
            opcao = obterOpcao(itensMenu.size());

            indice = opcao - 1;
        }

        return indice;
    }
	
	public static void montaMenu(List<String> itens, String titulo, String textoAdicional) {
		if (titulo != "") {			
			System.out.println("\n======================== " + titulo + " ========================\n");
		}
		
		if (textoAdicional != "") {
			System.out.println("\n" + textoAdicional + "\n");
		}
	    
	    for (String item : itens) {
			System.out.println(item);
		}
	}

	public static int obterOpcao(int qtdeOpcoes) {
	    int opcao = -1;
	    while ((opcao < 0) || (opcao > qtdeOpcoes))
	    {
	    	System.out.print("\nSelecione uma opção: ");
	    	opcao = ConversaoDeDatasUtil.stringToInt(entrada.nextLine());
	    	
	        if ((opcao < 0) || (opcao > qtdeOpcoes)) {
	        	System.out.println("Opção inválida.");
	        }
	    }
	    
	    return opcao;
	}
	
    private static <T> String getAtributos(T elemento, List<String> nomesAtributos) {
        StringBuilder result = new StringBuilder();

        try {
            for (String nomeAtributo : nomesAtributos) {
                Field field = elemento.getClass().getDeclaredField(nomeAtributo);
                field.setAccessible(true);
                Object value = field.get(elemento);

                if (result.length() > 0) {
                    result.append("\t");
                }
                
                if (value != null) {					
                	result.append(value.toString());
				}
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return "";
        }

        return result.toString();
    }

}
