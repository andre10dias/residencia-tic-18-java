package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Veiculo;
import Service.VeiculoService;
import Util.ControllerUtil;
import Util.MenuUtil;

public class VeiculoController implements IController<VeiculoController> {
	
	public static List<Veiculo> listaVeiculos;
	
	private Scanner entrada = new Scanner(System.in);
	
	public static VeiculoController getInstance() {
		return new VeiculoController();
	}
	
	@Override
	public String getNome() {
		return "veiculo";
	}
    
	@Override
	public void cadastrar() {
    	carregar();
    	System.out.println("\n======================== Cadastrar veiculo ========================");
		
		System.out.print("\nNúmero: ");
		String numero = entrada.nextLine();;
		
		Veiculo veiculo = new Veiculo(numero);
		salvar(veiculo);
    }
	
	@Override
	public void editar() {
    	carregar();
    	System.out.println("\n======================== Editar veiculo ========================\n");
    	
    	Veiculo veiculo = new Veiculo();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(veiculo);
		Integer indice = MenuUtil.menuSelecionarElemento(listaVeiculos, nomesAtributos, "");
		veiculo = listaVeiculos.get(indice);
		
		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		System.out.print("\nNúmero: ");
		String nome = entrada.nextLine();
		
		if (nome != null && nome != "") {
			veiculo.setNumero(nome);
		}
		
		atualizar(indice, veiculo);
    }
	
	@Override
	public void listar() {
		carregar();
		System.out.println("\n======================== Listar veiculo ========================\n");
		
		if (listaVeiculos != null && !listaVeiculos.isEmpty()) {
			System.out.println("Número");
			for (Veiculo veiculo : listaVeiculos) {
				System.out.println(veiculo.getNumero());
			}
		}
		else {
			System.err.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	@Override
	public void remover() {
		carregar();
    	System.out.println("\n======================== Remover veiculos ========================\n");
    	
    	Veiculo veiculo = new Veiculo();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(veiculo);
		Integer indice = MenuUtil.menuSelecionarElemento(listaVeiculos, nomesAtributos, "");
		veiculo = listaVeiculos.get(indice);
		excluir(veiculo);
	}
    
    private static void carregar() {
    	VeiculoService service = VeiculoService.getInstance();
    	listaVeiculos = service.carregar();
    }
	
    private static void salvar(Veiculo veiculo) {
		try {
			VeiculoService service = VeiculoService.getInstance();
			service.adicionar(listaVeiculos, veiculo);
			service.salvar(listaVeiculos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Veiculo buscar(Integer indice) {
		VeiculoService service = VeiculoService.getInstance();
		return service.buscar(listaVeiculos, indice);
	}
	
	private static void atualizar(Integer indice, Veiculo veiculo) {
		VeiculoService service = VeiculoService.getInstance();
		
		if (service.atualizar(listaVeiculos, indice, veiculo) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	private static void excluir(Veiculo veiculo) {
		VeiculoService service = VeiculoService.getInstance();
		
		if (listaVeiculos.indexOf(veiculo) != -1) {
			service.excluir(listaVeiculos, veiculo);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
