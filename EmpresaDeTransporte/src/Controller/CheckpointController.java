package Controller;

import java.util.List;

import Model.Checkpoint;
import Service.CheckpointService;

public class CheckpointController {
	
	public static List<Checkpoint> listaCheckpoints;
	
	private final CheckpointService service;

    public CheckpointController() {
        this.service = new CheckpointService();
    }
    
    public void carregar() {
    	listaCheckpoints = service.carregar();
    }
	
	public void salvar(Checkpoint checkpoint) {
		try {
			service.adicionar(listaCheckpoints, checkpoint);
			service.salvar(listaCheckpoints);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaCheckpoints.isEmpty()) {
			System.out.println("\nLista de Checkpoints cadastrados:\n");
			for (Checkpoint checkpoint : listaCheckpoints) {
				System.out.println(checkpoint.getPontoDeParada().getNome() 
					+ "\t" + checkpoint.getDataHoraFormatada());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Checkpoint buscar(Integer indice) {
		return service.buscar(listaCheckpoints, indice);
	}
	
	public void atualizar(Integer indice, Checkpoint checkpoint) {
		if (service.atualizar(listaCheckpoints, indice, checkpoint) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Checkpoint checkpoint) {
		if (listaCheckpoints.indexOf(checkpoint) != -1) {
			service.excluir(listaCheckpoints, checkpoint);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
