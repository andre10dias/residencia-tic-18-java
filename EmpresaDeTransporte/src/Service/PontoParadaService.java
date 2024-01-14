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

public class PontoParadaService implements IService<PontoParada> {
	
	private static final String PONTO_PARADA_PATH = "src/Bd/pontoParada.txt";
	
    public PontoParadaService() {
	}

	@Override
	public List<PontoParada> carregar() {
		List<PontoParada> lista = new ArrayList<>();
        File arquivo = new File(PONTO_PARADA_PATH);
        String linha;
        
        if (arquivo.exists()) {			
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("\nLendo arquivo " + PONTO_PARADA_PATH + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			lista.add(new PontoParada(linha));
        		}
        		
        	} catch (IOException e) {
        		System.err.println("\nErro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return lista;
	}

	@Override
	public void salvar(List<PontoParada> dados) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(PONTO_PARADA_PATH))) {
    		System.err.println("\nSalvando dados no arquivo " + PONTO_PARADA_PATH + "...\n");
    		
    		for (PontoParada dado : dados) {				
    			writer.write(dado.getNome());
    			writer.newLine();
			}
        } catch (IOException e) {
            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
        }
	}

	@Override
	public void adicionar(List<PontoParada> dados, PontoParada objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<PontoParada> dados) {
		for (PontoParada pontoParada : dados) {
            System.out.println(pontoParada);
        }
	}

	@Override
	public PontoParada buscar(List<PontoParada> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public PontoParada atualizar(List<PontoParada> dados, Integer indice, PontoParada objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<PontoParada> dados, PontoParada objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nPonto de parada removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
