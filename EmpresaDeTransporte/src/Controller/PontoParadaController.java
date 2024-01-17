package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Model.PontoParada;
import Model.Trajeto;
import Model.Trecho;
import Model.PontoParada;
import Model.PontoParada;
import Service.EmpresaDeTransporteService;
import Service.PontoParadaService;
import Util.ControllerUtil;
import Util.MenuUtil;

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
    	
    	PontoParada pontoParada = new PontoParada();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(pontoParada);
		Integer indice = MenuUtil.menuSelecionarElemento(listaPontoParadas, nomesAtributos, "");
		pontoParada = listaPontoParadas.get(indice);
		
		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		if (nome != null && nome != "") {
			pontoParada.setNome(nome);
		}
		
		atualizar(indice, pontoParada);
	}

	@Override
	public void listar() {
		carregar();
		System.out.println("\n======================== Listar ponto de parada ========================\n");
		
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
	
	/*
	 * Deleta os Pontos de parada sem trechos associados 
	 * */
	@Override
	public void remover() {
		carregar();
		List<PontoParada> listaPontoParadaSemTrechossAssociados = getListaPontoParadaSemTrechoAssociados();
		
    	System.out.println("\n======================== Remover pontoParadas ========================\n");
		
		if (!listaPontoParadaSemTrechossAssociados.isEmpty()) {			
			PontoParada pontoParada = new PontoParada();
			List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(pontoParada);
			Integer indice = MenuUtil.menuSelecionarElemento(listaPontoParadaSemTrechossAssociados, nomesAtributos, "");
			pontoParada = listaPontoParadaSemTrechossAssociados.get(indice);
			excluir(pontoParada, listaPontoParadaSemTrechossAssociados);
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");
		}
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
	
	public void excluir(PontoParada pontoParada, List<PontoParada> lista) {
		if (lista.indexOf(pontoParada) != -1) {
			service.excluir(listaPontoParadas, pontoParada);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	private List<PontoParada> getListaPontoParadaSemTrechoAssociados() {
    	List<PontoParada> listaPontoParadaSemTrechossAssociados = new ArrayList<>();
    	
    	for (PontoParada pp : listaPontoParadas) {
    		List<Trecho> listaTrechos = EmpresaDeTransporteService.buscarTrechosPorPontoParada(pp.getNome());
    		
    		if (listaTrechos.isEmpty()) {
    			listaPontoParadaSemTrechossAssociados.add(pp);
			}
		}
    	
    	return listaPontoParadaSemTrechossAssociados;
	}

}
