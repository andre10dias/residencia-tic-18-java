package Controller;

import java.util.List;

import Model.Veiculo;
import Service.VeiculoService;

public class VeiculoController {
	
	public static List<Veiculo> listaVeiculos;
	
	private final VeiculoService service;

    public VeiculoController() {
        this.service = new VeiculoService();
        listaVeiculos = service.carregar();
    }
	
	public void salvar(Veiculo veiculo) {
		try {
			service.adicionar(listaVeiculos, veiculo);
			service.salvar(listaVeiculos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() {
		if (!listaVeiculos.isEmpty()) {
			System.out.println("\nLista de veículos cadastrados:\n");
			for (Veiculo veiculo : listaVeiculos) {
				System.out.println(veiculo.getNumero());
			}
		}
		else {
			System.out.println("\nNão existem resultados para serem exibidos.");			
		}
	}
	
	public void atualizar(Integer indice, Veiculo veiculo) {
		if (service.atualizar(listaVeiculos, indice, veiculo) != null) {
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}
	
	public void excluir(Veiculo veiculo) {
		if (listaVeiculos.indexOf(veiculo) != -1) {
			service.excluir(listaVeiculos, veiculo);
			System.out.println("\nDados atualizados com sucesso.");
		}
		else {
			System.out.println("\nDados não localizados.");
		}
	}

}
