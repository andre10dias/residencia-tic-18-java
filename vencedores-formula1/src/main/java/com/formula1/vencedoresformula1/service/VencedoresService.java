package com.formula1.vencedoresformula1.service;

import java.util.List;
import java.util.Map;

import com.formula1.vencedoresformula1.DAO.DAO;
import com.formula1.vencedoresformula1.model.Piloto;

public class VencedoresService {
	
	public static List<Piloto> getAll() {
		return DAO.getListaPilotos();
	}
	
	public static List<Piloto> getPilotosBrasileiros() {
		return DAO.getListaPilotosByPais("Brasil");
	}
	
	public static List<Piloto> getTopCinco() {
		return DAO.getTops(5);
	}
	
	public static List<Piloto> getTopDez() {
		return DAO.getTops(10);
	}
	
	public static Map<String, List<Piloto>> getVitoriasPorPais() {
		return DAO.getNumerosVitoriasByPais();
	}

}
