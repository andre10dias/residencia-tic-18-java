package services;

import java.util.List;

import dao.ImovelDAO;
import models.Imovel;

public class ImovelService {

	public static List<Imovel> getImoveis() {
		return ImovelDAO.getAll();
	}
	
	public static void salvarImovel(Imovel i) {
		ImovelDAO.save(i);
	}

	public static void removerImovel(Imovel i) {
		ImovelDAO.remove(i);
	}

	public static List<Imovel> getImoveisComClientes() {
		return ImovelDAO.getImoveisComClientes();
	}

}
