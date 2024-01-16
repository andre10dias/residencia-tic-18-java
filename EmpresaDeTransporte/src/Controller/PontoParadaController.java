package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Model.PontoParada;
import Model.PontoParada;
import Service.PontoParadaService;

public class PontoParadaController implements IController<PontoParadaController> {
	
	public static List<PontoParada> listaPontoParadas;
	
	private final PontoParadaService service = new PontoParadaService();
	private Scanner entrada = new Scanner(System.in);

//    public PontoParadaController() {
//        this.service = new PontoParadaService();
//    }
	
	public static PontoParadaController getInstance() {
		return new PontoParadaController();
	}

	@Override
	public String getNome() {
		return "ponto de parada";
	}

	@Override
	public void cadastrar() {
		carregar();
    	System.out.println("\n======================== Cadastrar pontoParada ========================");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		PontoParada pontoParada = new PontoParada(nome);
		salvar(pontoParada);
	}

	@Override
	public void editar() {
		carregar();
    	System.out.println("\n======================== Editar pontoParadas ========================\n");
    	
		//Integer indice = Menu.menuSelecionarPontoParada(listaPontoParadas);
		//PontoParada pontoParada = listaPontoParadas.get(indice);
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		if (nome != null && nome != "") {
			//pontoParada.setNome(nome);
		}
		
		//atualizar(indice, pontoParada);
	}

	@Override
	public void remover() {
		// TODO Auto-generated method stub
		
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
