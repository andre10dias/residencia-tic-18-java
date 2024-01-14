package Controller;

import java.util.List;

import Model.Trecho;
import Service.TrechoService;

public class TrechoController {
	
	public static List<Trecho> listaTrechos;
	
	private final TrechoService service;

    public TrechoController() {
        this.service = new TrechoService();
    }
    
    public void carregar() {
    	listaTrechos = service.carregar();
    }
	
	public void salvar(Trecho trecho) {
		try {
			service.adicionar(listaTrechos, trecho);
			service.salvar(listaTrechos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaTrechos.isEmpty()) {
			System.out.println("\nLista de Trechos cadastrados:\n");
			for (Trecho trecho : listaTrechos) {
				System.out.println(trecho.getOrigem().getNome() + "\t" + trecho.getDestino().getNome() 
					+ "\t" + trecho.getIntervaloEstimado());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Trecho buscar(Integer indice) {
		return service.buscar(listaTrechos, indice);
	}
	
	public void atualizar(Integer indice, Trecho trecho) {
		if (service.atualizar(listaTrechos, indice, trecho) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Trecho trecho) {
		if (listaTrechos.indexOf(trecho) != -1) {
			service.excluir(listaTrechos, trecho);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
