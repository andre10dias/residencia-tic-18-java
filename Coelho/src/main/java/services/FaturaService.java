package services;

import java.util.List;

import dao.FaturaDAO;
import models.Fatura;
import models.Imovel;

public class FaturaService {
	
	public static List<Fatura> getFaturas() {
		return FaturaDAO.getAll();
	}
	
	public static List<Fatura> getFaturasQuitadas() {
		return FaturaDAO.getFaturasQuitadas(true);
	}
	
	public static List<Fatura> getFaturasPendentesByImovel(Imovel imovel) {
		return FaturaDAO.getFaturasQuitadas(false);
	}
	
	public static Fatura registraLeitura(Imovel imovel, Double leituraAtual) {
		Fatura faturaAnterior = null;
		Fatura f = null;
		int idFatura = getFaturas().size()+1;
		
		if (!getFaturas().isEmpty()) {
			faturaAnterior = getFaturas().get((getFaturas().size()-1));
			f = new Fatura(imovel, leituraAtual, faturaAnterior.getLeituraAtual());
			f.setId(idFatura);
		}
		else {
			f = new Fatura(imovel, leituraAtual);
			f.setId(idFatura);
		}
		
		Fatura fatura = FaturaDAO.save(f);
		return fatura;
	}
	
	public static Fatura getFaturaById(Integer faturaId) {
		return FaturaDAO.getFaturaById(faturaId);
	}

}
