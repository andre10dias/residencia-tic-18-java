package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Fatura;
import Models.Imovel;

public class FaturaService {
	
	private static List<Fatura> faturas;
	
	public static List<Fatura> getFaturas() {
		if (faturas == null) {
			faturas = new ArrayList<>(); 
		}
		
		return faturas;
	}
	
	public static void addFatura(Fatura f) {
		if (faturas == null) {
			faturas = new ArrayList<>();
		}
		
		faturas.add(f);
	}
	
	public static List<Fatura> getFaturasQuitadas() {
		List<Fatura> quitadas = new ArrayList<>();
		
		for (Fatura fatura : getFaturas()) {
			if (fatura.isQuitada()) {
				quitadas.add(fatura);
			}
		}
		
		return quitadas;
	}
	
	public static List<Fatura> getFaturasPendentesByImovel(Imovel imovel) {
		List<Fatura> pendentes = new ArrayList<>();
		
		for (Fatura fatura : getFaturas()) {
			if (fatura.getImovel().equals(imovel) && !fatura.isQuitada()) {
				pendentes.add(fatura);
			}
		}
		
		return pendentes;
	}
	
	public static Fatura registraLeitura(Imovel imovel, int leituraAtual) {
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
		
		addFatura(f);
		return f;
	}
	
	public static Fatura getFaturaById(Integer faturaId) {
		List<Fatura> faturas = getFaturas();
		
		for (Fatura f : faturas) {
			if (f.getId().equals(faturaId)) {
				return f;
			}
		}
		
		return null;
	}

}
