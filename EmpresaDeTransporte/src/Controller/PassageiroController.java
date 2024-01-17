package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Passageiro;
import Service.PassageiroService;
import Util.ControllerUtil;
import Util.MenuUtil;

public class PassageiroController implements IController<PassageiroController> {
	
	public static List<Passageiro> listaPassageiros;
	
	private static PassageiroService service = new PassageiroService();
	private Scanner entrada = new Scanner(System.in);

//    public PassageiroController() {
//        PassageiroController.service = new PassageiroService();
//    }
	
	public static PassageiroController getInstance() {
		return new PassageiroController();
	}
	
	@Override
	public String getNome() {
		return "passageiro";
	}
    
	@Override
    public void cadastrar() {
    	carregar();
    	System.out.println("\n======================== Cadastrar passageiro ========================");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		System.out.print("\nNúmero do cartão: ");
		String numeroCartao = entrada.nextLine();
		
		Passageiro passageiro = new Passageiro(nome, numeroCartao);
		salvar(passageiro);
    }
    
	@Override
    public void editar() {
    	carregar();
    	System.out.println("\n======================== Editar passageiros ========================\n");
    	
    	Passageiro passageiro = new Passageiro();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(passageiro);
		Integer indice = MenuUtil.menuSelecionarElemento(listaPassageiros, nomesAtributos, "");
		passageiro = listaPassageiros.get(indice);
		
		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		System.out.print("\nNúmero do cartão: ");
		String numeroCartao = entrada.nextLine();
		
		if (nome != null && nome != "") {
			passageiro.setNome(nome);
		}
		
		if (numeroCartao != null && numeroCartao != "") {
			passageiro.setNumeroCartao(numeroCartao);
		}
		
		atualizar(indice, passageiro);
    }
    
	@Override
    public void listar() {
    	carregar();
		System.out.println("\n======================== Listar passageiros ========================\n");
		
		if (listaPassageiros != null && !listaPassageiros.isEmpty()) {
			System.out.println("Nome \t Número cartão");
			for (Passageiro passageiro : listaPassageiros) {
				System.out.println(passageiro.getNome() + "\t" + passageiro.getNumeroCartao());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	@Override
	public void remover() {
		carregar();
    	System.out.println("\n======================== Editar passageiros ========================\n");
    	
    	Passageiro passageiro = new Passageiro();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(passageiro);
		Integer indice = MenuUtil.menuSelecionarElemento(listaPassageiros, nomesAtributos, "");
		passageiro = listaPassageiros.get(indice);
		excluir(passageiro);
	}
	
	public Passageiro buscar(Integer indice) {
		return service.buscar(listaPassageiros, indice);
	}
	
	private static void carregar() {
    	listaPassageiros = service.carregar();
    }
	
	private static void salvar(Passageiro passageiro) {
		try {
			service.adicionar(listaPassageiros, passageiro);
			service.salvar(listaPassageiros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    private static void atualizar(Integer indice, Passageiro passageiro) {
		if (service.atualizar(listaPassageiros, indice, passageiro) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
    
    private static void excluir(Passageiro passageiro) {
		if (listaPassageiros.indexOf(passageiro) != -1) {
			service.excluir(listaPassageiros, passageiro);
			System.out.println("\nPassageiro removido com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
