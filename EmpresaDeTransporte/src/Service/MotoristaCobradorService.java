package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Jornada;
import Model.MotoristaCobrador;
import Util.ControllerUtil;

public class MotoristaCobradorService implements IService<MotoristaCobrador> {
	
	private static final String MOTORISTA_COBRADOR_PATH = PathService.MOTORISTA_COBRADOR_PATH;
	
    public static MotoristaCobradorService getInstance() {
    	return new MotoristaCobradorService();
	}

	@Override
	public List<MotoristaCobrador> carregar() {
		List<MotoristaCobrador> lista = new ArrayList<>();
        File arquivo = new File(MOTORISTA_COBRADOR_PATH);
        
        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new MotoristaCobrador());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, MotoristaCobrador.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            MotoristaCobrador motoristaCobrador = EmpresaDeTransporteFactory.criarMotoristaCobradorDeJSONObject(objJson);
            lista.add(motoristaCobrador);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<MotoristaCobrador> dados) {
		File arquivo = new File(MOTORISTA_COBRADOR_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, MotoristaCobrador.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<MotoristaCobrador> dados, MotoristaCobrador objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<MotoristaCobrador> dados) {
		for (MotoristaCobrador dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public MotoristaCobrador buscar(List<MotoristaCobrador> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public MotoristaCobrador atualizar(List<MotoristaCobrador> dados, Integer indice, MotoristaCobrador objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<MotoristaCobrador> dados, MotoristaCobrador objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
