package questao2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import model.Estudante;

public class LerArquivo {
	public static void main(String[] args) {
        String nomeArquivo = "estudantes.json";
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.err.println("O arquivo não existe: " + nomeArquivo);
            return;
        }
        
        /**
         * Utilizando o try-with-resources para garantir o fechamento correto do 
         * recurso FileReader
         * */
        try (FileReader fileReader = new FileReader(arquivo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
        	List<Estudante> lista = new ArrayList<>();

            String linha;
            System.out.println("Lendo arquivo " + nomeArquivo + "...\n");
            while ((linha = bufferedReader.readLine()) != null) {
            	JSONObject json = new JSONObject(linha);
            	
            	if (json.get("Estudante") != null) {					
            		String estudanteJson = json.get("Estudante").toString();
            		json = new JSONObject(estudanteJson.replace("[", "").replace("]", ""));
				}
            	
            	String nome = json.getString("nome");
            	String cpf = json.getString("cpf");
            	Float cra = json.getFloat("cra");
            	Integer anoDeAdmissão = json.getInt("anoDeAdmissao");
            	
            	Estudante e = new Estudante(nome, cpf, cra, anoDeAdmissão);
            	lista.add(e);
            }
            
            imprimeDados(lista);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
	
	private static void imprimeDados(List<Estudante> lista) {
		for (Estudante estudante : lista) {
			System.out.println(estudante.toString());
		}
	}
}
