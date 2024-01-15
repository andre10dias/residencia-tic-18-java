package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Passageiro;

public class PassageiroService implements IService<Passageiro> {
	
	private static final String PASSAGEIRO_PATH = PathService.PASSAGEIRO_PATH;
	
    public PassageiroService() {
	}

    @Override
    public List<Passageiro> carregar() {
    	List<Passageiro> lista = new ArrayList<>();
        File arquivo = new File(PASSAGEIRO_PATH);
        
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	String[] attr = linha.split(";");
            
            if (attr.length > 1) {						
            	lista.add(new Passageiro(attr[0], attr[1]));
			}
            else {
            	lista.add(new Passageiro(attr[0]));
            }
        }

        return lista;
    }

    @Override
    public void salvar(List<Passageiro> dados) {
    	List<String> lista = new ArrayList<>();
    	File arquivo = new File(PASSAGEIRO_PATH);
    	
    	for (Passageiro dado : dados) {
			lista.add(dado.getNome() + ";" + dado.getNumeroCartao());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
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
