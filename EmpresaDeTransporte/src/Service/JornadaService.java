package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Factory.EmpresaDeTransporteFactory;
import Model.Jornada;
import Model.Trajeto;
import Model.Veiculo;
import Util.ControllerUtil;
import Util.ConversaoDeDatasUtil;

public class JornadaService implements IService<Jornada> {
	
	private static final String JORNADA_PATH = PathService.JORNADA_PATH;
	
    public static JornadaService getInstance() {
    	return new JornadaService();
	}

	@Override
	public List<Jornada> carregar() {
		List<Jornada> lista = new ArrayList<>();
        File arquivo = new File(JORNADA_PATH);

        List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(new Jornada());
        JSONArray dados = EmpresaDeTransporteService.recuperarDados(arquivo, Jornada.class, nomesAtributos);
        
        for (int i = 0; i < dados.length(); i++) {
        	JSONObject objJson = dados.getJSONObject(i);
            Jornada jornada = EmpresaDeTransporteFactory.criarJornadaDeJSONObject(objJson);
            lista.add(jornada);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Jornada> dados) {
    	File arquivo = new File(JORNADA_PATH);
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, dados, Jornada.class)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Jornada> dados, Jornada objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Jornada> dados) {
		for (Jornada dado : dados) {
            System.out.println(dado);
        }
	}

	@Override
	public Jornada buscar(List<Jornada> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public Jornada atualizar(List<Jornada> dados, Integer indice, Jornada objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<Jornada> dados, Jornada objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nDado removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
}
