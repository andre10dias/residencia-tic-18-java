package Controller;

import java.util.List;

import Model.Jornada;
import Service.JornadaService;

public class JornadaController {
	
	public static List<Jornada> listaJornadas;

    public static JornadaController getInstance() {
        return new JornadaController();
    }
    
    public void carregar() {
    	JornadaService service = JornadaService.getInstance();
    	listaJornadas = service.carregar();
    }
	
	public void salvar(Jornada jornada) {
		try {
			JornadaService service = JornadaService.getInstance();
			service.adicionar(listaJornadas, jornada);
			service.salvar(listaJornadas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaJornadas.isEmpty()) {
			System.out.println("\nLista de Jornadas cadastrados:\n");
			for (Jornada jornada : listaJornadas) {
				System.out.println(jornada.getDataInicioFormatada() + "\t" + jornada.getDataFimFormatada() 
						+ "\t" + jornada.getTrajeto().getCodigo() + "\t" + jornada.getMotoristaCobrador().getNome() 
						+ "\t" + jornada.getVeiculo().getNumero());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Jornada buscar(Integer indice) {
		JornadaService service = JornadaService.getInstance();
		return service.buscar(listaJornadas, indice);
	}
	
	public void atualizar(Integer indice, Jornada jornada) {
		JornadaService service = JornadaService.getInstance();
		
		if (service.atualizar(listaJornadas, indice, jornada) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Jornada jornada) {
		JornadaService service = JornadaService.getInstance();
		
		if (listaJornadas.indexOf(jornada) != -1) {
			service.excluir(listaJornadas, jornada);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
