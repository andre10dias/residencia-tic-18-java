package Controller;

import java.util.List;
import java.util.Scanner;

import Menu.Menu;
import Model.MotoristaCobrador;
import Model.Passageiro;
import Service.MotoristaCobradorService;
import Util.ControllerUtil;
import Util.MenuUtil;

public class MotoristaCobradorController implements IController<MotoristaCobradorController> {
	
	public static List<MotoristaCobrador> listaMotoristaCobradores;
	
	private static MotoristaCobradorService service = new MotoristaCobradorService();
	private Scanner entrada = new Scanner(System.in);

//    public MotoristaCobradorController() {
//        this.service = new MotoristaCobradorService();
//    }
	
	public static PassageiroController getInstance() {
		return new PassageiroController();
	}
	
	@Override
	public String getNome() {
		return "motorista/cobrador";
	}
	
	@Override
	public void cadastrar() {
    	carregar();
    	System.out.println("\n======================== Cadastrar motorista/cobrador ========================");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();;
		
		MotoristaCobrador motoristaCobrador = new MotoristaCobrador(nome);
		salvar(motoristaCobrador);
    }
	
	@Override
	public void editar() {
    	carregar();
    	System.out.println("\n======================== Editar motorista/cobrador ========================\n");
    	
    	MotoristaCobrador motoristaCobrador = new MotoristaCobrador();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(motoristaCobrador);
		Integer indice = MenuUtil.menuSelecionarElemento(listaMotoristaCobradores, nomesAtributos);
		motoristaCobrador = listaMotoristaCobradores.get(indice);
		
		System.out.println("\nDeixe o campo em branco caso não deseje altera-lo (apenas pressione ENTER).");
		
		System.out.print("\nNome: ");
		String nome = entrada.nextLine();
		
		if (nome != null && nome != "") {
			motoristaCobrador.setNome(nome);
		}
		
		atualizar(indice, motoristaCobrador);
    }
	
	@Override
	public void listar() {
		carregar();
		System.out.println("\n======================== Listar motorista/cobrador ========================\n");
		
		if (listaMotoristaCobradores != null && !listaMotoristaCobradores.isEmpty()) {
			System.out.println("Nome");
			for (MotoristaCobrador motoristaCobrador : listaMotoristaCobradores) {
				System.out.println(
						motoristaCobrador.getNome() 
//						+ "\t" + motoristaCobrador.getJornada().getDataInicioFormatada()
//						+ "\t" + motoristaCobrador.getJornada().getDataFimFormatada()
				);
			}
		}
		else {
			System.err.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	@Override
	public void remover() {
		carregar();
    	System.out.println("\n======================== Editar motoristaCobradors ========================\n");
    	
    	MotoristaCobrador motoristaCobrador = new MotoristaCobrador();
		List<String> nomesAtributos = ControllerUtil.obterNomesAtributos(motoristaCobrador);
		Integer indice = MenuUtil.menuSelecionarElemento(listaMotoristaCobradores, nomesAtributos);
		motoristaCobrador = listaMotoristaCobradores.get(indice);
		excluir(motoristaCobrador);
	}
    
    private static void carregar() {
    	listaMotoristaCobradores = service.carregar();
    }
	
	private static void salvar(MotoristaCobrador motoristaCobrador) {
		try {
			service.adicionar(listaMotoristaCobradores, motoristaCobrador);
			service.salvar(listaMotoristaCobradores);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MotoristaCobrador buscar(Integer indice) {
		return service.buscar(listaMotoristaCobradores, indice);
	}
	
	private static void atualizar(Integer indice, MotoristaCobrador motoristaCobrador) {
		if (service.atualizar(listaMotoristaCobradores, indice, motoristaCobrador) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public static void excluir(MotoristaCobrador motoristaCobrador) {
		if (listaMotoristaCobradores.indexOf(motoristaCobrador) != -1) {
			service.excluir(listaMotoristaCobradores, motoristaCobrador);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
