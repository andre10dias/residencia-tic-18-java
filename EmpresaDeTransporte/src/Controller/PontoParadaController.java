package Controller;

import java.util.List;

import Model.PontoParada;
import Service.PontoParadaService;

public class PontoParadaController {
	
	public static List<PontoParada> listaPontoParadas;
	
	private final PontoParadaService service;

    public PontoParadaController() {
        this.service = new PontoParadaService();
    }
    
    public void carregar() {
    	listaPontoParadas = service.carregar();
    }
	
	public void salvar(PontoParada pontoParada) {
		try {
			service.adicionar(listaPontoParadas, pontoParada);
			service.salvar(listaPontoParadas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaPontoParadas.isEmpty()) {
			System.out.println("\nLista de Pontos de parada cadastrados:\n");
			for (PontoParada pontoParada : listaPontoParadas) {
				System.out.println(pontoParada.getNome());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public PontoParada buscar(Integer indice) {
		return service.buscar(listaPontoParadas, indice);
	}
	
	public void atualizar(Integer indice, PontoParada pontoParada) {
		if (service.atualizar(listaPontoParadas, indice, pontoParada) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(PontoParada pontoParada) {
		if (listaPontoParadas.indexOf(pontoParada) != -1) {
			service.excluir(listaPontoParadas, pontoParada);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
