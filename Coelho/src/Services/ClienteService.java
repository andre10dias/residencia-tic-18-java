package Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Models.Cliente;
import Models.Imovel;

public class ClienteService {

	private static List<Cliente> clientes;
	
	public static List<Cliente> getClientes() {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		return clientes;
	}
	
	public static void addCliente(Cliente c) {
		if (clientes == null) {
			clientes = new ArrayList<>();
		}
		
		clientes.add(c);
	}
	
	public static void removeCliente(Cliente c) {
		clientes.remove(c);
	}

	// Método para alterar dados do cliente
    public static void alterarDadosCliente(Cliente cliente, String novoNome, String novoCpf) {
        cliente.alterarDados(novoNome, novoCpf);
    }
	
	public static Cliente getClienteByImovel(Imovel i) {
		for (Cliente cliente : clientes) {
			List<Imovel> imoveis = cliente.getImoveis();
			
			for (Imovel imovel : imoveis) {
				if (imovel.getMatricula() == i.getMatricula()) {
					return cliente;
				}
			}
		}
		
		return null;
	}
	
	public static List<Cliente> retornaClientesComImovel() {
		Set<Cliente> lista = new HashSet<>();
		
		for (Cliente cliente : clientes) {
			if (!cliente.getImoveis().isEmpty()) {
				lista.add(cliente);
			}
		}
		
		return new ArrayList<Cliente>(lista);
	}

}
