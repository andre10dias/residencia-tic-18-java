package Questao2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscreverArquivo {

	public static void main(String[] args) {
		String nomeArquivo = "saida.txt";
		String entrada = "";
		
		/**
         * Utilizando o try-with-resources para garantir o fechamento correto do 
         * recurso Scanner
         * */
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {

            System.out.println("Digite várias linhas de texto:");
            System.out.println("(Precione ENTER com a linha vazia para sair)");
            do {
            	entrada = scanner.nextLine();
            	writer.write(entrada);
                writer.newLine();
            }
            while (!entrada.isEmpty());
            System.out.println("O arquivo " + nomeArquivo + ", foi salvo com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }

	}

}
