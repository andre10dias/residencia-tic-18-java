package Controller;

import java.util.List;

import Model.Passageiro;
import Service.PassageiroService;

public class PassageiroController {
	
	public static List<Passageiro> listaPassageiros;
	
	private final PassageiroService service;

    public PassageiroController() {
        this.service = new PassageiroService();
    }
    
    public void carregar() {
    	listaPassageiros = service.carregar();
    }
	
	public void salvar(Passageiro passageiro) {
		try {
			service.adicionar(listaPassageiros, passageiro);
			service.salvar(listaPassageiros);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaPassageiros.isEmpty()) {
			System.out.println("\nLista de passageiros cadastrados:\n");
			for (Passageiro passageiro : listaPassageiros) {
				System.out.println(passageiro.getNome() + "\t" + passageiro.getNumeroCartao());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public Passageiro buscar(Integer indice) {
		return service.buscar(listaPassageiros, indice);
	}
	
	public void atualizar(Integer indice, Passageiro passageiro) {
		if (service.atualizar(listaPassageiros, indice, passageiro) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Passageiro passageiro) {
		if (listaPassageiros.indexOf(passageiro) != -1) {
			service.excluir(listaPassageiros, passageiro);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
