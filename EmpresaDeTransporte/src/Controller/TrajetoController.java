package Controller;

import java.util.List;

import Model.Trajeto;
import Model.Trecho;
import Service.TrajetoService;

public class TrajetoController {
	
	public static List<Trajeto> listaTrajetos;
	
	private final TrajetoService service;

    public TrajetoController() {
        this.service = new TrajetoService();
    }
    
    public void carregar() {
    	listaTrajetos = service.carregar();
    }
	
	public void salvar(Trajeto trajeto) {
		try {
			service.adicionar(listaTrajetos, trajeto);
			service.salvar(listaTrajetos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaTrajetos.isEmpty()) {
			System.out.println("\nLista de Trajetos cadastrados:\n");
			for (int i = 0; i < listaTrajetos.size(); i++) {
				String codigoTrajeto = listaTrajetos.get(i).getCodigo();
				List<Trecho> listaTrechos = listaTrajetos.get(i).getListaTrechos();
				
				if (listaTrechos.isEmpty()) {					
					System.out.println(codigoTrajeto);
				}
				else {					
					for (Trecho trecho : listaTrechos) {					
						System.out.println(codigoTrajeto + "\t" + trecho.getOrigem().getNome() 
								+ "\t" + trecho.getDestino().getNome() + "\t" + trecho.getIntervaloEstimado());
					}
				}
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Trajeto buscar(Integer indice) {
		return service.buscar(listaTrajetos, indice);
	}
	
	public void atualizar(Integer indice, Trajeto trajeto) {
		if (service.atualizar(listaTrajetos, indice, trajeto) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Trajeto trajeto) {
		if (listaTrajetos.indexOf(trajeto) != -1) {
			service.excluir(listaTrajetos, trajeto);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
