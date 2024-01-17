package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Converter.TrechoConverter;
import DTO.TrechoDTO;
import Model.Trecho;
import Model.Trajeto;
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
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void listar() {
		if (!listaTrajetos.isEmpty()) {
			System.out.println("\nLista de Trajetos cadastrados:\n");
			for (int i = 0; i < listaTrajetos.size(); i++) {
				Integer codigoTrajeto = listaTrajetos.get(i).getCodigo();
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

	@Override
	public void remover() {
		// TODO Auto-generated method stub
		
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
	
	private Trecho selecionarTrecho(List<Trecho> listaTrechos) {
    	TrechoDTO trechoDto = new TrechoDTO();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(trechoDto);
		
		// Removendo o atributo cógigo para não aparecer na listagem
		for (int i = 0; i < nomesAtributos.size(); i++) {
			if (nomesAtributos.get(i).equals("codigo")) {
				nomesAtributos.remove(i);
			}
		}
		
		List<TrechoDTO> listaTrechosDto = TrechoConverter.convertToDTO(listaTrechos);
		
		Integer indice = MenuUtil.menuSelecionarElemento(listaTrechosDto, nomesAtributos, "");
		trechoDto = listaTrechosDto.get(indice);
		
		Trecho trecho = TrechoController.buscarTrechoPorCodigo(trechoDto.getCodigo());
		indice = listaTrechos.indexOf(trecho);
		
		return listaTrechos.get(indice);
	}

}
