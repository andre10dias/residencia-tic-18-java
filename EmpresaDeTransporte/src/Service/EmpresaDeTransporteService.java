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
	
	public static List<Trajeto> buscarTrajetosPorCodigo(Integer codigoTrajeto) {
		File arquivo = new File(TRAJETO_PATH);
		List<Trajeto> listaTrajeto = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			String[] attr = linha.split(";");
			
			Integer codigo = Integer.valueOf(attr[CODIGO]);
			if (codigo.equals(codigoTrajeto)) {
				listaTrajeto.add(new Trajeto(codigoTrajeto));
			}
		}
		
		return listaTrajeto;
	}
	
	public static List<Trecho> buscarTrechosPorPontoParada(String origemDestino) {
		List<Trecho> listaTrecho = recuperaTrecho();
		List<Trecho> lista = new ArrayList<>();
		
		for (Trecho trecho : listaTrecho) {
			if (trecho.getOrigem().getNome().equals(origemDestino) 
					|| trecho.getDestino().getNome().equals(origemDestino)) {
				lista.add(trecho);
			}
		}
		
		return lista;
	}
	
	public static List<Trecho> buscarTrechosSemTrajetosAssociados() {
		List<Trajeto> listaTrajeto = recuperaTrajeto();
		List<Trecho> listaTrecho = recuperaTrecho();
		List<Trecho> listaTrechosSemTrajetosAssociados = new ArrayList<>();
		
		for (Trecho trecho : listaTrecho) {
            boolean estaPresente = false;

            for (Trajeto trajeto : listaTrajeto) {
                for (Trecho tt : trajeto.getListaTrechos()) {
					if (tt.getCodigo().equals(trecho.getCodigo())) {
						estaPresente = true;
						break;
					}
				}
            }

            if (!estaPresente) {
            	listaTrechosSemTrajetosAssociados.add(trecho);
            }
        }
		
		return listaTrechosSemTrajetosAssociados;
	}
	
	private static List<Trecho> recuperaTrecho() {
		File arquivo = new File(TRECHO_PATH);
		List<Trecho> listaTrecho = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			String[] attr = linha.split(";");
			
			Integer codigoTrecho = Integer.valueOf(attr[CODIGO]);
			PontoParada origem = new PontoParada(attr[ORIGEM]);
			PontoParada destino = new PontoParada(attr[DESTINO]);
			Integer intervalo = Integer.valueOf(attr[INTERVALO]);
			
			listaTrecho.add(new Trecho(codigoTrecho, origem, destino, intervalo));
		}
		
		return listaTrecho;
	}
	
	private static List<Trajeto> recuperaTrajeto() {
		File arquivo = new File(TRAJETO_PATH);
		List<Trecho> listaTrecho = recuperaTrecho();
		List<Trajeto> listaTrajeto = new ArrayList<>();
		
		List<String> lista = recuperarDados(arquivo);
		for (String linha : lista) {
			List<Trecho> listaT = new ArrayList<>();
			String[] attr = linha.split(";");
			
			String codigoTrajeto = attr[0];
			
			for (int i = 1; i < attr.length; i++) {
				for (Trecho tt : listaTrecho) {
					if (tt.getCodigo().equals(Integer.valueOf(attr[i]))) {
						listaT.add(tt);
					}
				}
			}
			
			listaTrajeto.add(new Trajeto(Integer.valueOf(codigoTrajeto), listaT));
		}
    	
    	return listaTrajeto;
	}

}
