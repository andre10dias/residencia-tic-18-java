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

public class PassageiroService implements IService<Passageiro> {
	
	private static final String PASSAGEIRO_PATH = "src/Bd/passageiro.txt";
	
    public PassageiroService() {
	}

    @Override
    public List<Passageiro> carregar() {
    	List<Passageiro> lista = new ArrayList<>();
        File arquivo = new File(PASSAGEIRO_PATH);
        String linha;
        
        if (arquivo.exists()) {	
	        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
	            System.out.println("Lendo arquivo " + PASSAGEIRO_PATH + "...\n");
	
	            while ((linha = reader.readLine()) != null) {
	                String[] attr = linha.split(";");
	                
	                if (attr.length > 1) {						
	                	lista.add(new Passageiro(attr[0], attr[1]));
					}
	                else {
	                	lista.add(new Passageiro(attr[0]));
	                }
	            }
	
	        } catch (IOException e) {
	            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
        }

        return lista;
    }

    @Override
    public void salvar(List<Passageiro> dados) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(PASSAGEIRO_PATH))) {
            for (Passageiro passageiro : dados) {
                writer.write(passageiro.getNome() + ";" + passageiro.getNumeroCartao());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    @Override
    public void adicionar(List<Passageiro> dados, Passageiro objeto) {
        dados.add(objeto);
    }

    @Override
    public void listar(List<Passageiro> dados) {
    	for (Passageiro passageiro : dados) {
            System.out.println(passageiro);
        }
    }
    
    @Override
    public Passageiro buscar(List<Passageiro> dados, Integer indice) {
        return dados.get(indice);
    }

    @Override
    public Passageiro atualizar(List<Passageiro> dados, Integer indice, Passageiro objeto) {
    	dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
    }

    @Override
    public void excluir(List<Passageiro> dados, Passageiro objeto) {
    	if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nPassageiro removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
    }
    
}
