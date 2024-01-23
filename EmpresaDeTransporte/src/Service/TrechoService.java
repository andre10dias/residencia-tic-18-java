package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Trecho;
import Util.ControllerUtil;

public class TrechoService implements IService<Trecho> {
	
	private static final String TRECHO_PATH = PathService.TRECHO_PATH;
	
    public static TrechoService getInstace() {
    	return new TrechoService();
	}

	@Override
	public List<Trecho> carregar() {
		List<Trecho> lista = new ArrayList<>();
        File arquivo = new File(TRECHO_PATH);

        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Trecho());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Trecho.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
        	Trecho trecho = EmpresaDeTransporteFactory.criarTrechoDeJSONObject(objJson);
            lista.add(trecho);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trecho> dados) {
    	File arquivo = new File(TRECHO_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Trecho.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Trecho> dados, Trecho objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trecho> dados) {
		for (Trecho dado : dados) {
            System.out.println(dado);
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
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public static Trecho buscarTrechoPorCodigo(List<Trecho> dados, Integer codigo) {
		for (Trecho dado : dados) {
			if (dado.getCodigo().equals(codigo)) {
				return dado;
			}
		}

		return null;
	}
	
}
