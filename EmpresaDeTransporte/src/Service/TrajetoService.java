package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Trajeto;
import Util.ControllerUtil;

public class TrajetoService implements IService<Trajeto> {
	
	public static List<Trajeto> listaTrajetos;
	
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
    public static TrajetoService getInstance() {
    	return new TrajetoService();
	}

	@Override
	public List<Trajeto> carregar() {
		List<Trajeto> lista = new ArrayList<>();
        File arquivo = new File(TRAJETO_PATH);

        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Trajeto());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Trajeto.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Trajeto trajeto = EmpresaDeTransporteFactory.criarTrajetoDeJSONObject(objJson);
            lista.add(trajeto);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trajeto> dados) {
    	File arquivo = new File(TRAJETO_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Trajeto.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Trajeto> dados, Trajeto objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trajeto> dados) {
		for (Trajeto dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Trajeto buscar(List<Trajeto> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Trajeto atualizar(List<Trajeto> dados, Integer indice, Trajeto objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Trajeto> dados, Trajeto objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public static Trajeto buscarTrajetoPorCodigo(List<Trajeto> listaTrajetos, Integer codigoTrajeto) {
		for (Trajeto trajeto : listaTrajetos) {
			if (trajeto.getCodigo().equals(codigoTrajeto)) {
				return trajeto;
			}
		}
		
		return null;
	}

}
