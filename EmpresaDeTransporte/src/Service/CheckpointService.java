package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Checkpoint;
import Util.ControllerUtil;

public class CheckpointService implements IService<Checkpoint> {
	
	private static final String CHECKPOINT_PATH = PathService.CHECKPOINT_PATH;
	
    public static CheckpointService getInstance() {
    	return new CheckpointService();
	}

	@Override
	public List<Checkpoint> carregar() {
		List<Checkpoint> lista = new ArrayList<>();
        File arquivo = new File(CHECKPOINT_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Checkpoint());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Checkpoint.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Checkpoint checkpoint = EmpresaDeTransporteFactory.criarChekpointDeJSONObject(objJson);
            lista.add(checkpoint);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Checkpoint> dados) {
    	File arquivo = new File(CHECKPOINT_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Checkpoint.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Checkpoint> dados, Checkpoint objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Checkpoint> dados) {
		for (Checkpoint dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Checkpoint buscar(List<Checkpoint> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Checkpoint atualizar(List<Checkpoint> dados, Integer indice, Checkpoint objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Checkpoint> dados, Checkpoint objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
