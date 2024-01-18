package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Converter.TrajetoConverter;
import Converter.TrechoConverter;
import DTO.TrajetoDTO;
import DTO.TrechoDTO;
import Model.Trajeto;
import Model.Trecho;
import Service.EmpresaDeTransporteService;
import Service.TrajetoService;
import Util.ControllerUtil;
import Util.MenuUtil;

public class TrajetoController implements IController<TrajetoController> {
	
	public static List<Trajeto> listaTrajetos;
	
	private static TrajetoService service = new TrajetoService();

//    public TrajetoController() {
//        TrajetoController.service = new TrajetoService();
//    }
	
	public static TrajetoController getInstance() {
		return new TrajetoController();
	}
	
	@Override
	public String getNome() {
		return "trajeto";
	}
    
	@Override
    public void cadastrar() {
		TrechoController trechoController = TrechoController.getInstance();
		trechoController.carregar();
		carregar();
		
    	List<Trecho> listaTrechos = TrechoController.listaTrechos;
    	
    	List<Integer> listaCodigos = getListaCodigos(listaTrajetos);
    	Integer codigo = ControllerUtil.obterCodigo(listaCodigos);
    	List<Trecho> lista = new ArrayList<>();
    	int opcao;
    	
    	do {			
    		System.out.println("\n======================== Cadastrar trajeto ========================");
    		Trecho trecho = selecionarTrecho(listaTrechos);
    		lista.add(trecho);
    		
    		List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Sim", "[ 0 ] Não"));
            
            MenuUtil.montaMenu(itens, "", "Deseja incluir um novo trecho ao trajeto?");
            opcao = MenuUtil.obterOpcao(itens.size());
		} while (opcao != 0);
		
		Trajeto trajeto = new Trajeto(codigo, lista);
		salvar(trajeto);
    }

	@Override
	public void editar() {
		carregar();
		TrechoController trechoController = TrechoController.getInstance();
		trechoController.carregar();
		
//    	List<Trecho> listaTrechos = TrechoController.listaTrechos;
    	
    	System.out.println("\n======================== Editar trajetos ========================\n");
    	
    	Trajeto trajeto = selecionarTrajeto(listaTrajetos);
    	Integer indice = listaTrajetos.indexOf(trajeto);
		
//		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		List<Trecho> lista = new ArrayList<>();
    	int opcao = -1;
    	
    	do {			
    		//System.out.println("\n======================== Editar trajeto ========================");
    		List<Trecho> listaTrechosSemTrajetosAssociados = EmpresaDeTransporteService
    				.buscarTrechosSemTrajetosAssociados();
    		
    		if (!listaTrechosSemTrajetosAssociados.isEmpty()) {				
    			Trecho trecho = selecionarTrecho(listaTrechosSemTrajetosAssociados);
    			lista.add(trecho);
    			
    			List<String> itens = new ArrayList<>(Arrays.asList("[ 1 ] Sim", "[ 0 ] Não"));
    			
    			MenuUtil.montaMenu(itens, "", "Deseja incluir um novo trecho ao trajeto?");
    			opcao = MenuUtil.obterOpcao(itens.size());
			}
    		else {
    			System.out.println("\nNão existem resultados para serem exibidos.");
    		}
		} while (opcao != 0);
		
		trajeto.setListaTrechos(lista);
		atualizar(indice, trajeto);
	}
	
	@Override
	public void listar() {
		carregar();
		System.out.println("\n======================== Listar trajetos ========================\n");
		
		if (!listaTrajetos.isEmpty()) {
			System.out.println("\nLista de Trajetos cadastrados:\n");
			
//			System.out.println("\t Origem \t Destino \t Intervalo estimado");
			for (int i = 0; i < listaTrajetos.size(); i++) {
				List<Trecho> listaTrechos = listaTrajetos.get(i).getListaTrechos();
				
				for (int j = 0; j < listaTrechos.size(); j++) {
					if (j == 0) {
						System.out.print("Trajeto " + (i+1) + " - ");
					}
					
					System.out.print("Trecho " + (j+1) + ": " + listaTrechos.get(j).getOrigem().getNome() 
							+ " -> " + listaTrechos.get(j).getDestino().getNome() 
							+ " Intervalo: " + listaTrechos.get(j).getIntervaloEstimado());
					
					if (j != listaTrechos.size()-1) {
						System.out.print(" - ");
					}
				}
				
				System.out.println();
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}

	@Override
	public void remover() {
		carregar();
		TrechoController trechoController = TrechoController.getInstance();
		trechoController.carregar();
    	
    	System.out.println("\n======================== Remover trajetos ========================\n");
    	
    	Trajeto trajeto = selecionarTrajeto(listaTrajetos);
    	excluir(trajeto);
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
	
	private List<Integer> getListaCodigos(List<Trajeto> listaTrajeto) {
		List<Integer> listaCodigos = new ArrayList<>();
    	for (Trajeto trajeto : listaTrajeto) {
    		listaCodigos.add(trajeto.getCodigo());
    	}
    	
    	return listaCodigos;
	}
	
	public static Trajeto buscarTrajetoPorCodigo(Integer codigo) {
		return TrajetoService.buscarTrajetoPorCodigo(listaTrajetos, codigo);
	}
	
	private Trajeto selecionarTrajeto(List<Trajeto> listaTrajetos) {
		TrajetoDTO trajetoDto = new TrajetoDTO();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(trajetoDto);
		
		// Removendo o atributo cógigo para não aparecer na listagem
		for (int i = 0; i < nomesAtributos.size(); i++) {
			if (nomesAtributos.get(i).equals("codigo")) {
				nomesAtributos.remove(i);
			}
		}
		
		List<TrajetoDTO> listaTrajetosDto = null;
		
		try {
			TrajetoConverter converter = TrajetoConverter.getInstance();
			listaTrajetosDto = converter.convertToDTO(listaTrajetos);
		} catch (Exception e) {
			System.err.println("Erro ao converter os dados: " + e.getMessage());
		}
		
		Integer indice = MenuUtil.menuSelecionarElemento(listaTrajetosDto, nomesAtributos, "");
		trajetoDto = listaTrajetosDto.get(indice);
		
		return buscarTrajetoPorCodigo(trajetoDto.getCodigo());
	}
	
	private Trecho selecionarTrecho(List<Trecho> listaTrechos) {
    	TrechoDTO trechoDto = new TrechoDTO();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(trechoDto);
		
		// Removendo o atributo cógigo para não aparecer na listagem
		for (int i = 0; i < nomesAtributos.size(); i++) {
			if (nomesAtributos.get(i).equals("codigo")) {
				nomesAtributos.remove(i);
			}
		}
		
		List<TrechoDTO> listaTrechosDto = null;
		
		try {
			TrechoConverter converter = TrechoConverter.getInstance();
			listaTrechosDto = converter.convertToDTO(listaTrechos);
		} catch (Exception e) {
			System.err.println("Erro ao converter os dados: " + e.getMessage());
		}
		
		Integer indice = MenuUtil.menuSelecionarElemento(listaTrechosDto, nomesAtributos, "");
		trechoDto = listaTrechosDto.get(indice);
		
		Trecho trecho = TrechoController.buscarTrechoPorCodigo(trechoDto.getCodigo());
		indice = listaTrechos.indexOf(trecho);
		
		return listaTrechos.get(indice);
	}

}
