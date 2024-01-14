package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Veiculo;

public class VeiculoService implements IService<Veiculo> {
	
	private static final String VEICULO_PATH = "src/Bd/veiculo.txt";
	
    public VeiculoService() {
	}

	@Override
    public List<Veiculo> carregar() {
    	List<Veiculo> lista = new ArrayList<>();
        File arquivo = new File(VEICULO_PATH);
        String linha;
        
        if (arquivo.exists()) {			
        	try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
        		System.err.println("Lendo arquivo " + VEICULO_PATH + "...\n");
        		
        		while ((linha = reader.readLine()) != null) {
        			lista.add(new Veiculo(linha));
        		}
        		
        	} catch (IOException e) {
        		System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        	}
		}
        
        return lista;
    }

    @Override
    public void salvar(List<Veiculo> dados) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(VEICULO_PATH))) {
    		System.err.println("Salvando dados no arquivo " + VEICULO_PATH + "...\n");
    		
    		for (Veiculo dado : dados) {				
    			writer.write(dado.getNumero());
    			writer.newLine();
			}
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @Override
    public void adicionar(List<Veiculo> dados, Veiculo veiculo) {
        dados.add(veiculo);
    }

    @Override
    public void listar(List<Veiculo> dados) {
    	for (Veiculo veiculo : dados) {
            System.out.println(veiculo);
        }
    }
    
//    @Override
//    public Integer buscar(List<Veiculo> dados, Veiculo veiculo) {
//        return dados.indexOf(veiculo);
//    }

    @Override
    public Veiculo atualizar(List<Veiculo> dados, Integer indice, Veiculo veiculo) {
    	dados.set(indice, veiculo);
    	salvar(dados);
        return dados.get(indice);
    }

    @Override
    public void excluir(List<Veiculo> dados, Veiculo veiculo) {
    	if (dados.remove(veiculo)) {
    		salvar(dados);
			System.out.println("\nVeículo removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
    }
    
}
