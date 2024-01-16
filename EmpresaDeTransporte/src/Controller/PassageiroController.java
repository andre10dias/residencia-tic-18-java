package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Model.Passageiro;
import Service.PassageiroService;

public class PassageiroController {
	
	public static List<Passageiro> listaPassageiros;
	
	private static PassageiroService service = new PassageiroService();
	private static Scanner entrada = new Scanner(System.in);

//    public PassageiroController() {
//        PassageiroController.service = new PassageiroService();
//    }
    
    public static void cadastrarPassageiro() {
    	carregar();
    	System.out.println("\n======================== Cadastrar passageiro ========================");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		System.out.print("\nNúmero do cartão: ");
		String numeroCartao = entrada.nextLine();
		
		Passageiro passageiro = new Passageiro(nome, numeroCartao);
		salvar(passageiro);
    }
    
    public static void editarPassageiro() {
    	carregar();
    	System.out.println("\n======================== Editar passageiros ========================\n");
    	
		Integer indice = Menu.menuSelecionarPassageiro(listaPassageiros);
		Passageiro passageiro = listaPassageiros.get(indice);
		
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
    
    public static void listar() {
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
	
	public static void removerPassageiro() {
		carregar();
    	System.out.println("\n======================== Editar passageiros ========================\n");
    	
		Integer indice = Menu.menuSelecionarPassageiro(listaPassageiros);
		Passageiro passageiro = listaPassageiros.get(indice);
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
