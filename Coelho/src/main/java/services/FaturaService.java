package services;

import java.util.List;

import dao.FaturaDAO;
import dao.ImovelDAO;
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
	
	public static List<Fatura> getFaturasByImovel(Imovel imovel, Boolean isFaturaQuitada) {
		return FaturaDAO.getFaturasByImovel(imovel, isFaturaQuitada);
	}
	
	public static Fatura registraLeitura(Imovel imovel, Double leituraAtual) {
		Fatura faturaAnterior = null;
		Fatura f = null;
		List<Fatura> faturas = getFaturasByImovel(imovel, null);
		
		if (!faturas.isEmpty()) {
			faturaAnterior = faturas.get((faturas.size()-1));
			
			imovel.setLeituraAnterior(faturaAnterior.getLeituraAtual());
			imovel.setLeituraAtual(leituraAtual);
			
			f = new Fatura(imovel, leituraAtual, faturaAnterior.getLeituraAtual());
		}
		else {
			f = new Fatura(imovel, leituraAtual);
			imovel.setLeituraAtual(leituraAtual);
		}
		
		Fatura fatura = FaturaDAO.save(f);
		ImovelDAO.update(imovel);
		return fatura;
	}
	
	public static Fatura getFaturaById(Integer faturaId) {
		return FaturaDAO.getFaturaById(faturaId);
	}

}
