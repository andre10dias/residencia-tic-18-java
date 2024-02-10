package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.ClienteDAO;
import models.Cliente;
import models.Imovel;

public class ClienteService {
	
	public static List<Cliente> getClientes() {
		return ClienteDAO.getAll();
	}
	
	public static void salvarCliente(Cliente c) {
		ClienteDAO.save(c);
	}
	
	public static void removerCliente(Cliente c) {
		ClienteDAO.remove(c);
	}

    public static void alterarDadosCliente(Cliente cliente, String novoNome, String novoCpf) {
    	cliente = ClienteDAO.getClienteById(cliente.getId());
    	cliente.setNome(novoNome);
    	cliente.setCpf(novoCpf);
    	
        ClienteDAO.update(cliente);
    }
	
	public static Cliente getClienteByImovel(Imovel i) {
		return ClienteDAO.getClienteByImovel(i);
	}
	
	public static List<Cliente> retornaClientesComImovel() {
		Set<Cliente> lista = new HashSet<>();
		
		for (Cliente cliente : getClientes()) {
			if (!cliente.getImoveis().isEmpty()) {
				lista.add(cliente);
			}
		}
		
		return new ArrayList<Cliente>(lista);
	}

}
