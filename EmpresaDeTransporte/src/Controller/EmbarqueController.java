package Controller;

import java.util.List;

import Model.Embarque;
import Service.EmbarqueService;

public class EmbarqueController {
	
	public static List<Embarque> listaEmbarques;

    public static EmbarqueController getInstance() {
        return new EmbarqueController();
    }
    
    public void carregar() {
    	EmbarqueService service = EmbarqueService.getInstance();
    	listaEmbarques = service.carregar();
    }
	
	public void salvar(Embarque embarque) {
		try {
			EmbarqueService service = EmbarqueService.getInstance();
			service.adicionar(listaEmbarques, embarque);
			service.salvar(listaEmbarques);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaEmbarques.isEmpty()) {
			System.out.println("\nLista de Embarques cadastrados:\n");
			for (Embarque embarque : listaEmbarques) {
				System.out.println(embarque.getPassageiro().getNome() + "\t" + embarque.getPontoDeEmbarque().getNome() 
						+ "\t" + embarque.getTipoCartao() + "\t" + embarque.getDataHoraFormatada());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Embarque buscar(Integer indice) {
		EmbarqueService service = EmbarqueService.getInstance();
		return service.buscar(listaEmbarques, indice);
	}
	
	public void atualizar(Integer indice, Embarque embarque) {
		EmbarqueService service = EmbarqueService.getInstance();
		
		if (service.atualizar(listaEmbarques, indice, embarque) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Embarque embarque) {
		EmbarqueService service = EmbarqueService.getInstance();
		
		if (listaEmbarques.indexOf(embarque) != -1) {
			service.excluir(listaEmbarques, embarque);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
