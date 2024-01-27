package Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Models.Cliente;
import Models.Imovel;

public class ImovelService {

	private static List<Imovel> imoveis;

	public static List<Imovel> getImoveis() {
		if (imoveis == null) {
			imoveis = new ArrayList<>();
		}

		return imoveis;
	}

	public static void addImovel(Imovel i) {
		if (imoveis == null) {
			imoveis = new ArrayList<>();
		}

		imoveis.add(i);
	}

	public static void removeImovel(Imovel i) {
		imoveis.remove(i);
	}

	public static List<Imovel> getImoveisComClientes() {
		List<Cliente> clientes = ClienteService.retornaClientesComImovel();
		Set<Imovel> lista = new HashSet<>();

		for (Cliente cliente : clientes) {
			for (Imovel imovel : cliente.getImoveis()) {
				lista.add(imovel);
			}
		}

		return new ArrayList<Imovel>(lista);
	}

}
