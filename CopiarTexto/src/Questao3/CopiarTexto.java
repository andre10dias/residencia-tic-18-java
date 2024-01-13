package Questao3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiarTexto {

    public static void main(String[] args) {
        String origem = "origem.txt";
        String destino = "destino.txt";
        String linha;

        try (BufferedReader reader = new BufferedReader(new FileReader(origem));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destino))) {

            while ((linha = reader.readLine()) != null) {
                writer.write(linha);
                writer.newLine();
            }

            System.out.println("Texto copiado do arquivo " + origem + " para o arquivo " + destino);

        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}

