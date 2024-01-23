package questao1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;

import model.Estudante;

public class EscreverArquivo {

	public static void main(String[] args) throws IOException {
		/**
         * Utilizando o try-with-resources para garantir o fechamento correto do 
         * recurso Scanner
         * */
        try (Scanner scanner = new Scanner(System.in)) {
        	List<Estudante> lista = new ArrayList<>();
        	String opcao = "";

            do {
            	System.out.print("Digite o nome do estudante: ");
            	String nome = scanner.nextLine();
            	
            	System.out.print("Digite o CPF: ");
            	String cpf = scanner.nextLine();
            	
            	System.out.print("CRA: ");
            	String cra = scanner.nextLine();
            	
            	System.out.print("Ano admissão: ");
            	String admissao = scanner.nextLine();
            	
            	if (nome.equals("") || cpf.equals("") || cra.equals("") 
            			|| admissao.equals("")) {
					System.out.println("\nTodos os campos são obrigatórios.");
				}
            	else {					
            		Estudante estudante = new Estudante(nome, cpf, Float.valueOf(cra), 
            				Integer.valueOf(admissao));
            		lista.add(estudante);
				}
            	
            	do {            		
            		System.out.println("\nDeseja continuar? \n [ 1 ] Sim \t [ 0 ] Não");
            		System.out.print("\nOpção: ");
            		opcao = scanner.nextLine();
            		
            		if (!opcao.equals("1") && !opcao.equals("0")) {
            			System.out.println("\nOpção inválida.");
            		}
            	} while(!opcao.equals("1") && !opcao.equals("0"));
            	
            	System.out.println();
            	
            } while (!opcao.equals("0"));
            
            if (!lista.isEmpty()) {	
            	gravarArquivo(lista);
			}
        	
        	//gravarArquivo(mock());
            
            if (opcao.equals("0")) {
				System.out.println("\nFinalizando programa...");
			}
        }
	}
	
	private static void gravarArquivo(List<Estudante> lista) {
		String nomeArquivo = "estudantes.json";
		JSONObject json = new JSONObject();

		try (Scanner scanner = new Scanner(System.in);
	             BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
			for (Estudante e : lista) {
//				json.put("nome", e.getNome());
//				json.put("cpf", e.getCpf());
//				json.put("cra", e.getCra());
//				json.put("anoDeAdmissao", e.getAnoDeAdmissão());
				
				json.put("Estudante", lista);
				
				writer.write(json.toString());
                writer.newLine();
			}
			
			System.out.println(json);
			System.out.println("O arquivo " + nomeArquivo + ", foi salvo com sucesso.");
		} catch (Exception e) {
			System.out.println("\nFalha ao gravar o arquivo: " + e.getMessage());
		}
	}
	
//	private static List<Estudante> mock() {
//		List<Estudante> lista = new ArrayList<>();
//		
//		Estudante estudante = new Estudante("Carlos", "123456879", 2.3f, 2023);
//		lista.add(estudante);
//		
//		Estudante estudante1 = new Estudante("Maria", "089713152", 3f, 2023);
//		lista.add(estudante1);
//		
//		Estudante estudante2 = new Estudante("João", "852123963", 5f, 2022);
//		lista.add(estudante2);
//		
//		Estudante estudante3 = new Estudante("Franciele", "7892563011", 3.1f, 2020);
//		lista.add(estudante3);
//		
//		return lista;
//	}

}
