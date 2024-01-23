package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.PassageiroFactory;
import Model.Passageiro;
import Util.ControllerUtil;

public class PassageiroService implements IService<Passageiro> {
	
	private static final String PASSAGEIRO_PATH = PathService.PASSAGEIRO_PATH;
	
    public static PassageiroService getInstance() {
    	return new PassageiroService();
	}

    @Override
    public List<Passageiro> carregar() {
    	List<Passageiro> lista = new ArrayList<>();
    	PassageiroFactory factory = PassageiroFactory.getInstance();
        File arquivo = new File(PASSAGEIRO_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Passageiro());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Passageiro.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Passageiro passageiro = factory.criarObjetoDeJSONObject(objJson);
            lista.add(passageiro);
		}

        return lista;
    }

    @Override
    public void salvar(List<Passageiro> dados) {
    	File arquivo = new File(PASSAGEIRO_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Passageiro.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
    }

    @Override
    public void adicionar(List<Passageiro> dados, Passageiro objeto) {
        dados.add(objeto);
    }

    @Override
    public void listar(List<Passageiro> dados) {
    	for (Passageiro dado : dados) {
            System.out.println(dado);
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
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
    }
    
}
