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
import Model.Trecho;

public class TrechoService implements IService<Trecho> {
	
	private static final String TRECHO_PATH = "src/Bd/trecho.txt";
	
	private final Integer ORIGEM = 0;
	private final Integer DESTINO = 1;
	private final Integer INTERVALO = 2;
	
    public TrechoService() {
	}

	@Override
	public List<Trecho> carregar() {
		List<Trecho> lista = new ArrayList<>();
        File arquivo = new File(TRECHO_PATH);
        String linha;
        
        if (arquivo.exists()) {			
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("\nLendo arquivo " + TRECHO_PATH + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			String[] attr = linha.split(";");
        			
        			PontoParada origem = new PontoParada(attr[ORIGEM]);
        			PontoParada destino = new PontoParada(attr[DESTINO]);
        			Integer intervaloEstimado = Integer.valueOf(attr[INTERVALO]);
        			
        			lista.add(new Trecho(origem, destino, intervaloEstimado));
        		}
        		
        	} catch (IOException e) {
        		System.err.println("\nErro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trecho> dados) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRECHO_PATH))) {
    		System.err.println("\nSalvando dados no arquivo " + TRECHO_PATH + "...\n");
    		
    		for (Trecho dado : dados) {				
    			writer.write(dado.getOrigem().getNome() + ";" + dado.getDestino().getNome() 
    					+ ";" + dado.getIntervaloEstimado());
    			writer.newLine();
			}
        } catch (IOException e) {
            System.err.println("\nErro ao salvar os dados: " + e.getMessage());
        }
	}

	@Override
	public void adicionar(List<Trecho> dados, Trecho objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trecho> dados) {
		for (Trecho trecho : dados) {
            System.out.println(trecho);
        }
	}

	@Override
	public Trecho buscar(List<Trecho> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Trecho atualizar(List<Trecho> dados, Integer indice, Trecho objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Trecho> dados, Trecho objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nVeículo removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
