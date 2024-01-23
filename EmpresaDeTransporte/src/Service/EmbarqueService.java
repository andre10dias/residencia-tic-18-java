package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Embarque;
import Util.ControllerUtil;

public class EmbarqueService implements IService<Embarque> {
	
	private static final String EMBARQUE_PATH = PathService.EMBARQUE_PATH;
	
    public static EmbarqueService getInstance() {
    	return new EmbarqueService();
	}

	@Override
	public List<Embarque> carregar() {
		List<Embarque> lista = new ArrayList<>();
        File arquivo = new File(EMBARQUE_PATH);

        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Embarque());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Embarque.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Embarque embarque = EmpresaDeTransporteFactory.criarEmbarqueDeJSONObject(objJson);
            lista.add(embarque);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Embarque> dados) {
    	File arquivo = new File(EMBARQUE_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Embarque.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Embarque> dados, Embarque objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Embarque> dados) {
		for (Embarque dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Embarque buscar(List<Embarque> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Embarque atualizar(List<Embarque> dados, Integer indice, Embarque objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Embarque> dados, Embarque objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
