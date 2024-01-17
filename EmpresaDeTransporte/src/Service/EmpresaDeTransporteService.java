package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;

public class EmpresaDeTransporteService {
	
	private static final String TRECHO_PATH = PathService.TRECHO_PATH;
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
	private final static Integer CODIGO = 0;
	private final static Integer ORIGEM = 1;
	private final static Integer DESTINO = 2;
	private final static Integer INTERVALO = 3;
	
	protected static List<String> recuperarDados(File arquivo) {
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
	
	protected static Boolean gravarDados(File arquivo, List<String> listaDados) {
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
	
	public static List<Trajeto> buscarTrajetosPorCodigoTrecho(Integer codigoTrecho) {
		File arquivo = new File(TRAJETO_PATH);
		List<Trajeto> listaTrajeto = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			String[] attr = linha.split(";");
			
			Integer codigoTrajeto = Integer.valueOf(attr[CODIGO]);
			if (codigoTrajeto.equals(codigoTrecho)) {
				listaTrajeto.add(new Trajeto(codigoTrajeto));
			}
		}
		
		return listaTrajeto;
	}
	
	protected static List<Trecho> buscarTrechosPorCodigoTrajeto(Integer codigoTrajeto) {
		File arquivo = new File(TRECHO_PATH);
		List<Trecho> listaTrecho = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			String[] attr = linha.split(";");
			
			Integer codigoTrecho = Integer.valueOf(attr[CODIGO]);
			if (codigoTrecho.equals(codigoTrajeto)) {
				PontoParada origem = new PontoParada(attr[ORIGEM]);
				PontoParada destino = new PontoParada(attr[DESTINO]);
				Integer intervaloEstimado = Integer.valueOf(attr[INTERVALO]);
				
				listaTrecho.add(new Trecho(codigoTrecho, origem, destino, intervaloEstimado));
			}
		}
		
		return listaTrecho;
	}
	
	public static List<Trecho> buscarTrechosPorPontoParada(String origemDestino) {
		File arquivo = new File(TRECHO_PATH);
		List<Trecho> listaTrecho = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			String[] attr = linha.split(";");
			
			PontoParada origem = new PontoParada(attr[ORIGEM]);
			PontoParada destino = new PontoParada(attr[DESTINO]);
			
			if (origem.getNome().equals(origemDestino) || destino.getNome().equals(origemDestino)) {
				Integer codigoTrecho = Integer.valueOf(attr[CODIGO]);
				Integer intervaloEstimado = Integer.valueOf(attr[INTERVALO]);
				listaTrecho.add(new Trecho(codigoTrecho, origem, destino, intervaloEstimado));
			}
		}
		
		return listaTrecho;
	}

}
