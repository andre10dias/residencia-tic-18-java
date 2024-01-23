package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Veiculo;
import Util.ControllerUtil;

public class VeiculoService implements IService<Veiculo> {
	
	private static final String VEICULO_PATH = PathService.VEICULO_PATH;
	
    public static VeiculoService getInstance() {
    	return new VeiculoService();
	}

	@Override
    public List<Veiculo> carregar() {
    	List<Veiculo> lista = new ArrayList<>();
        File arquivo = new File(VEICULO_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Veiculo());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Veiculo.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Veiculo veiculo = EmpresaDeTransporteFactory.criarVeiculoDeJSONObject(objJson);
            lista.add(veiculo);
		}
        
        return lista;
    }

    @Override
    public void salvar(List<Veiculo> dados) {
    	File arquivo = new File(VEICULO_PATH);
    	
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
