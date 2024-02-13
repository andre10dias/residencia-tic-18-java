package com.formula1.vencedoresformula1.DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.formula1.vencedoresformula1.model.Piloto;

public class DAO {
	
	public static List<Piloto> getListaPilotos() {
		List<String> pilotos = DAO.lerArquivo();
		List<Piloto> listaPilotos = new ArrayList<>();
		
		for (int i = 1; i < pilotos.size(); i++) {
			String[] dados = pilotos.get(i).split(";");
			
			String pais = dados[0];
			String nome = dados[1];
			String vitorias = dados[2].replace("\n", "");
			
			Piloto piloto = new Piloto(
					pais,
					nome,
					Integer.valueOf(vitorias)
			);
			
			listaPilotos.add(piloto);
		}
		
		return listaPilotos;
	}
	
	public static List<Piloto> getListaPilotosByPais(String pais) {
		List<Piloto> listaPilotos = DAO.getListaPilotos();
		List<Piloto> pilotosPais = new ArrayList<>();
		
		listaPilotos.forEach(p -> {
	        if (p.getPais().equalsIgnoreCase(pais)) {
	        	pilotosPais.add(p);
	        }
	    });
		
		return pilotosPais;
	}
	
	public static List<Piloto> getTops(Integer top) {
		List<Piloto> listaPilotos = DAO.getListaPilotos();
		List<Piloto> listaCrescente = DAO
				.ordenaPorNumerosVitoriasDescrescente(listaPilotos);
		
		List<Piloto> topFive = new ArrayList<>();
		for (int i = 0; i < top; i++) {
			topFive.add(listaCrescente.get(i));
		}
		
		return topFive;
	}
	
	public static Map<String, List<Piloto>> getNumerosVitoriasByPais() {
		List<Piloto> listaPilotos = DAO.getListaPilotos();
		Map<String, List<Piloto>> listaVitoriasPorPais = new HashMap<>();
		List<Piloto> listaPilotosPorPais = new ArrayList<>();
		
		for (Piloto piloto : listaPilotos) {
			listaPilotosPorPais = DAO.getListaPilotosByPais(piloto.getPais());
			
			DAO.ordenaPorNumerosVitoriasDescrescente(listaPilotosPorPais);
			listaVitoriasPorPais.put(piloto.getPais(), listaPilotosPorPais);
		}
		
		return listaVitoriasPorPais;
	}
	
	private static List<String> getPaisesOrdenados(List<Piloto> listaPilotos) {
		List<String> listaPaises = new ArrayList<>();
		
		for (Piloto piloto : listaPilotos) {
			listaPaises.add(piloto.getPais());
		}
		
		Collections.sort(listaPaises, (p1, p2) -> p1.compareTo(p2));
		return listaPaises;
	}
	
	private static List<Piloto> ordenaPorNumerosVitoriasDescrescente(List<Piloto> listaPilotos) {
		Collections.sort(listaPilotos, (p1, p2) -> p2.getVitorias().compareTo(p1.getVitorias()));
		return listaPilotos;
	}
	
	private static List<Piloto> ordenaPorNumerosVitoriasCrescente(List<Piloto> listaPilotos) {
		Collections.sort(listaPilotos, (p1, p2) -> p1.getVitorias().compareTo(p2.getVitorias()));
		return listaPilotos;
	}
	
	private static List<String> lerArquivo() {
		List<String> linha = new ArrayList<>();
		String linhaArquivo = "";
		
		String nomeArquivo = "pilotos.csv";
		
		 try (BufferedReader reader = new BufferedReader(
				 new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"))) {
			
			System.out.println("Lendo arquivo...\n");
            while (reader.ready()) {
                linhaArquivo = reader.readLine() + "\n";
                linha.add(linhaArquivo);
            }
			
		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo " + e);
			e.printStackTrace();
		}
		
		return linha;
	}

}
