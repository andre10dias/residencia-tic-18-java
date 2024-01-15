package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Trajeto;
import Model.Trecho;

public class TrajetoService implements IService<Trajeto> {
	
	private static final String TRAJETO_PATH = PathService.TRAJETO_PATH;
	
    public TrajetoService() {
	}

	@Override
	public List<Trajeto> carregar() {
		List<Trajeto> lista = new ArrayList<>();
        File arquivo = new File(TRAJETO_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	Trajeto trajeto = new Trajeto(linha);
			lista.add(trajeto);
			
			List<Trecho> listaTrecho = EmpresaDeTransporteService
					.buscarTrechosPorCodigoTrajeto(trajeto);
			trajeto.setListaTrechos(listaTrecho);
		}
        
        return lista;
	}

	@Override
	public void salvar(List<Trajeto> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(TRAJETO_PATH);
    	
		for (Trajeto dado : dados) {
			lista.add(dado.getCodigo());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<Trajeto> dados, Trajeto objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<Trajeto> dados) {
		for (Trajeto trajeto : dados) {
            System.out.println(trajeto);
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
			System.out.println("\nPonto de parada removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
