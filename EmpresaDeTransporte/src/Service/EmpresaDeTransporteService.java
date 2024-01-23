package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Trajeto;
import Model.Trecho;
import Util.ControllerUtil;

public class EmpresaDeTransporteService {
	
	private static final String TRECHO_PATH = PathService.TRECHO_PATH;
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
	protected static JSONArray recuperarDados(File arquivo, Class<?> classe, List<String> nomesAtributos) {
		JSONArray jsonArray = new JSONArray();
		String linha;
		
		if (arquivo.exists()) {		
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("\nLendo arquivo " + arquivo + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			JSONObject json = new JSONObject(linha);
                	
                	if (json.get(classe.getSimpleName()) != null) {					
                		jsonArray = json.getJSONArray(classe.getSimpleName());
    				}
        		}
        		
        	} catch (IOException e) {
        		System.err.println("\nErro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return jsonArray;
	}
	
	protected static Boolean gravarDados(File arquivo, List<?> listaDados, Class<?> classe) {
		JSONObject json = new JSONObject();
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
			json.put(classe.getSimpleName(), listaDados);
			
			writer.write(json.toString());
            writer.newLine();
            
            return true;
        } catch (IOException e) {
            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
        }
		
		return false;
	}
	
	public static List<Trajeto> buscarTrajetosPorCodigo(Integer codigoTrajeto) {
		List<Trajeto> listaTrajeto = recuperaTrajeto();
		List<Trajeto> lista = new ArrayList<>();
		
		for (Trajeto trajeto : listaTrajeto) {
			if (trajeto.getCodigo().equals(codigoTrajeto)) {
				lista.add(trajeto);
			}
		}
		
		return lista;
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
		
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Trecho());
		JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Trecho.class, nomesAtributos);
		
		for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Trecho trecho = EmpresaDeTransporteFactory.criarTrechoDeJSONObject(objJson);
            listaTrecho.add(trecho);
		}
		
		return listaTrecho;
	}
	
	private static List<Trajeto> recuperaTrajeto() {
		File arquivo = new File(TRAJETO_PATH);
		List<Trajeto> listaTrajeto = new ArrayList<>();
		
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Trajeto());
		JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Trajeto.class, nomesAtributos);

		for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
        	Trajeto trajeto = EmpresaDeTransporteFactory.criarTrajetoDeJSONObject(objJson);
        	listaTrajeto.add(trajeto);
		}
    	
    	return listaTrajeto;
	}

}
