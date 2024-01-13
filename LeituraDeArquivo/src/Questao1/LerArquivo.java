package Questao1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

	public static void main(String[] args) {
        String nomeArquivo = "entrada.txt";
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

            String linha;
            System.out.println("Lendo arquivo " + nomeArquivo + "...\n");
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

}
