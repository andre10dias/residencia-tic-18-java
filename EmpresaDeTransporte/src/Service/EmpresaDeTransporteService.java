package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Passageiro;
import Model.PontoParada;
import Model.Trecho;

public class EmpresaDeTransporteService {
	
	public static List<String> recuperarDados(File arquivo) {
		List<String> lista = new ArrayList<>();
		String linha;
		
		if (arquivo.exists()) {			
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("\nLendo arquivo " + arquivo + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			lista.add(linha);
        		}
        		
        	} catch (IOException e) {
        		System.err.println("\nErro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return lista;
	}
	
	public static Boolean gravarDados(File arquivo, List<String> listaDados) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (String dado : listaDados) {
                writer.write(dado);
                writer.newLine();
            }
            
            return true;
        } catch (IOException e) {
            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
        }
		
		return false;
	}
	
//	public static PontoParada getPontoParadaByOrigemOrDestino(String origemDestino) {
//        File arquivo = new File(PONTO_PARADA_PATH);
//        PontoParada pontoParada = null;
//        
//        List<String> lista = recuperarDados(arquivo);
//        for (String linha : lista) {
//        	if (origemDestino.equals(linha)) {						
//				pontoParada = new PontoParada(linha);
//			}
//		}
//        
//        return pontoParada;
//	}

}
