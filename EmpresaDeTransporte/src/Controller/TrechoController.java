package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Converter.TrechoConverter;
import DTO.TrechoDTO;
import Model.PontoParada;
import Model.Trecho;
import Service.EmpresaDeTransporteService;
import Service.TrechoService;
import Util.ControllerUtil;
import Util.MenuUtil;

public class TrechoController implements IController<TrechoController> {
	
	public static List<Trecho> listaTrechos;
	
	private final TrechoService service = new TrechoService();
	private Scanner entrada = new Scanner(System.in);

//    public TrechoController() {
//        this.service = new TrechoService();
//    }
	
	public static TrechoController getInstance() {
		return new TrechoController();
	}
	
	@Override
	public String getNome() {
		return "trecho";
	}
    
	@Override
    public void cadastrar() {
    	carregar();
    	PontoParadaController pontoParadaController = PontoParadaController.getInstance();
    	pontoParadaController.carregar();
    	
    	List<Integer> listaCodigos = getListaCodigosTrecho();
    	
    	Integer codigo = ControllerUtil.obterCodigo(listaCodigos);
    	
    	System.out.println("\n======================== Cadastrar trecho ========================");
    	
    	PontoParada origem = selecionarPontoParada("Selecionar origem:");
    	PontoParada destino = selecionarPontoParada("Selecionar destino:");
		
		System.out.print("\nIntervalo estimado: ");
		String intervalo = entrada.nextLine();
		
		Trecho trecho = new Trecho(codigo, origem, destino, Integer.valueOf(intervalo));
		salvar(trecho);
    }	
    
	@Override
    public void editar() {
    	carregar();
    	System.out.println("\n======================== Editar trechos ========================\n");
    	
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
		
		Trecho trecho = buscarTrechoPorCodigo(trechoDto.getCodigo());
		indice = listaTrechos.indexOf(trecho);
		
//		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		PontoParada origem = selecionarPontoParada("Selecionar origem:");
    	PontoParada destino = selecionarPontoParada("Selecionar destino:");
		
    	System.out.print("\nIntervalo estimado: ");
		String intervalo = entrada.nextLine();
		
		if (origem != null) {
			trecho.setOrigem(origem);
		}
		
		if (destino != null) {
			trecho.setDestino(destino);
		}
		
		if (intervalo != null && intervalo != "") {
			trecho.setIntervaloEstimado(Integer.valueOf(intervalo));
		}
		
		atualizar(indice, trecho);
    }
    
	@Override
    public void listar() {
    	carregar();
		System.out.println("\n======================== Listar trechos ========================\n");
		
		if (listaTrechos != null && !listaTrechos.isEmpty()) {
			System.out.println("Origem \t Destino \t Intervalo estimado");
			for (Trecho trecho : listaTrechos) {
				System.out.println(trecho.getOrigem().getNome() + "\t" + trecho.getDestino().getNome() 
						+ "\t" + trecho.getIntervaloEstimado());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	/*
	 * Deleta os Trechos sem Trajetos associados
	 * */
	@Override
	public void remover() {
		carregar();
		List<Trecho> listaTrechosSemTrajetosAssociados = EmpresaDeTransporteService
				.buscarTrechosSemTrajetosAssociados();

		System.out.println("\n======================== Remover trechos ========================\n");
		
		if (!listaTrechosSemTrajetosAssociados.isEmpty()) {	
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
				listaTrechosDto = converter.convertToDTO(listaTrechosSemTrajetosAssociados);
			} catch (Exception e) {
				System.err.println("Erro ao converter os dados: " + e.getMessage());
			}
			
			Integer indice = MenuUtil.menuSelecionarElemento(listaTrechosDto, nomesAtributos, "Exibindo trechos sem trajeto associado:");
			trechoDto = listaTrechosDto.get(indice);
			
			Trecho trecho = buscarTrechoPorCodigo(trechoDto.getCodigo());
			indice = listaTrechos.indexOf(trecho);
			
			trecho = listaTrechosSemTrajetosAssociados.get(indice);
			excluir(trecho, listaTrechosSemTrajetosAssociados);
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");
		}
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
	
	public void excluir(Trecho trecho, List<Trecho> lista) {
		if (lista.indexOf(trecho) != -1) {
			service.excluir(listaTrechos, trecho);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	private List<Integer> getListaCodigosTrecho() {
		List<Integer> listaCodigos = new ArrayList<>();
    	for (Trecho trecho : listaTrechos) {
    		if (trecho.getCodigo() != null) {				
    			listaCodigos.add(trecho.getCodigo());
			}
    	}
    	
    	return listaCodigos;
	}
	
	public static Trecho buscarTrechoPorCodigo(Integer codigo) {
		return TrechoService.buscarTrechoPorCodigo(listaTrechos, codigo);
	}
	
	private PontoParada selecionarPontoParada(String texto) {
		PontoParada pontoParada = new PontoParada();
		PontoParadaController pontoParadaController = PontoParadaController.getInstance();
		pontoParadaController.carregar();
		
    	List<PontoParada> listaPontoParadas = PontoParadaController.listaPontoParadas;
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(pontoParada);
		
		Integer indice = MenuUtil.menuSelecionarElemento(listaPontoParadas, nomesAtributos, texto);
		
		return listaPontoParadas.get(indice);
	}

}
