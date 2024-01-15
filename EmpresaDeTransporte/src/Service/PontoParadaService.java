package Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.PontoParada;

public class PontoParadaService implements IService<PontoParada> {
	
	private static final String PONTO_PARADA_PATH = PathService.PONTO_PARADA_PATH;
	
    public PontoParadaService() {
	}

	@Override
	public List<PontoParada> carregar() {
		List<PontoParada> lista = new ArrayList<>();
        File arquivo = new File(PONTO_PARADA_PATH);

        List<String> dados = EmpresaDeTransporteService.recuperarDados(arquivo);
        for (String linha : dados) {
        	lista.add(new PontoParada(linha));
		}
        
        return lista;
	}

	@Override
	public void salvar(List<PontoParada> dados) {
		List<String> lista = new ArrayList<>();
    	File arquivo = new File(PONTO_PARADA_PATH);
    	
    	for (PontoParada dado : dados) {
			lista.add(dado.getNome());
		}
    	
    	if (EmpresaDeTransporteService.gravarDados(arquivo, lista)) {
			System.out.println("\nDados gravados com sucesso.");
		}
	}

	@Override
	public void adicionar(List<PontoParada> dados, PontoParada objeto) {
		dados.add(objeto);
	}

	@Override
	public void listar(List<PontoParada> dados) {
		for (PontoParada pontoParada : dados) {
            System.out.println(pontoParada);
        }
	}

	@Override
	public PontoParada buscar(List<PontoParada> dados, Integer indice) {
		return dados.get(indice);
	}

	@Override
	public PontoParada atualizar(List<PontoParada> dados, Integer indice, PontoParada objeto) {
		dados.set(indice, objeto);
    	salvar(dados);
        return dados.get(indice);
	}

	@Override
	public void excluir(List<PontoParada> dados, PontoParada objeto) {
		if (dados.remove(objeto)) {
    		salvar(dados);
			System.out.println("\nPonto de parada removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
