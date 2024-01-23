package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Veiculo;
import Util.ControllerUtil;

public class VeiculoService implements IService<Veiculo> {
	
	private static final String VEICULO_PATH = PathService.VEICULO_PATH;
	
    public VeiculoService() {
	}

	@Override
    public List<Veiculo> carregar() {
    	List<Veiculo> lista = new ArrayList<>();
        File arquivo = new File(VEICULO_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Veiculo());
        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo, Veiculo.class, nomesAtributos);
        for (String linha : dados) {
        	lista.add(new Veiculo(linha));
		}
        
        return lista;
    }

    @Override
    public void salvar(List<Veiculo> dados) {
//    	List<String> lista = new ArrayList<>();
    	File arquivo = new File(VEICULO_PATH);
    	
//    	for (Veiculo dado : dados) {
//			lista.add(dado.getNumero());
//		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Veiculo.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
    }

    @Override
    public void adicionar(List<Veiculo> dados, Veiculo objeto) {
        dados.add(objeto);
    }

    @Override
    public void listar(List<Veiculo> dados) {
    	for (Veiculo dado : dados) {
            System.out.println(dado);
        }
    }
    
    @Override
    public Veiculo buscar(List<Veiculo> dados, Integer indice) {
        return dados.get(indice);
    }

    @Override
    public Veiculo atualizar(List<Veiculo> dados, Integer indice, Veiculo objeto) {
    	dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
    }

    @Override
    public void excluir(List<Veiculo> dados, Veiculo objeto) {
    	if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
    }
    
}
