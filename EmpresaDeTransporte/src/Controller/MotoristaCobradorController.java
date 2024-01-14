package Controller;

import java.util.List;

import Model.MotoristaCobrador;
import Service.MotoristaCobradorService;

public class MotoristaCobradorController {
	
	public static List<MotoristaCobrador> listaMotoristaCobradores;
	
	private final MotoristaCobradorService service;

    public MotoristaCobradorController() {
        this.service = new MotoristaCobradorService();
    }
    
    public void carregar() {
    	listaMotoristaCobradores = service.carregar();
    }
	
	public void salvar(MotoristaCobrador motoristaCobrador) {
		try {
			service.adicionar(listaMotoristaCobradores, motoristaCobrador);
			service.salvar(listaMotoristaCobradores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaMotoristaCobradores.isEmpty()) {
			System.out.println("\nLista de Motoristas/Cobradores cadastrados:\n");
			for (MotoristaCobrador motoristaCobrador : listaMotoristaCobradores) {
				System.out.println(
						motoristaCobrador.getNome() 
						+ "\t" + motoristaCobrador.getInicioJornadaFormatado()
						+ "\t" + motoristaCobrador.getFimJornadaFormatado()
				);
			}
		}
		else {
			System.err.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public MotoristaCobrador buscar(Integer indice) {
		return service.buscar(listaMotoristaCobradores, indice);
	}
	
	public void atualizar(Integer indice, MotoristaCobrador motoristaCobrador) {
		if (service.atualizar(listaMotoristaCobradores, indice, motoristaCobrador) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(MotoristaCobrador motoristaCobrador) {
		if (listaMotoristaCobradores.indexOf(motoristaCobrador) != -1) {
			service.excluir(listaMotoristaCobradores, motoristaCobrador);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
