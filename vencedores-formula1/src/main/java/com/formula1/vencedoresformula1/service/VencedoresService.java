package com.formula1.vencedoresformula1.service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.formula1.vencedoresformula1.dao.GenericDAO;
import com.formula1.vencedoresformula1.dto.VitoriasPorPaisDTO;
import com.formula1.vencedoresformula1.model.Piloto;
import com.formula1.vencedoresformula1.util.VencedoresUtil;

public class VencedoresService {
	
	public static List<Piloto> getAll() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Piloto> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Piloto p";
        List<Piloto> pilotos = dao.executeQuery(jpql, Piloto.class, null);
        
        em.close();
        emf.close();
		
		return pilotos;
	}
	
	public static List<Piloto> getPilotosBrasileiros() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Piloto> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Piloto p WHERE p.pais = 'Brasil'";
        List<Piloto> pilotos = dao.executeQuery(jpql, Piloto.class, null);
        
        em.close();
        emf.close();
		
		return pilotos;
	}
	
	public static List<Piloto> getTopCinco() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Piloto> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Piloto p ORDER BY vitorias DESC";
        List<Piloto> pilotos = dao.executeQuery(jpql, Piloto.class, 5);
        
        em.close();
        emf.close();
		
		return pilotos;
	}
	
	public static List<Piloto> getTopDez() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Piloto> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Piloto p ORDER BY vitorias DESC";
        List<Piloto> pilotos = dao.executeQuery(jpql, Piloto.class, 10);
        
        em.close();
        emf.close();
		
		return pilotos;
	}
	
	public static List<VitoriasPorPaisDTO> getVitoriasPorPais() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Object[]> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p.pais, SUM(p.vitorias) FROM Piloto p "
        		+ "GROUP BY p.pais ORDER BY SUM(p.vitorias) DESC";
        List<Object[]> resultados = dao.executeQuery(jpql, Object[].class, null);
        
        List<VitoriasPorPaisDTO> listaDto = new LinkedList<>();
        for (Object[] piloto : resultados) {
        	String pais = (String) piloto[0];
			Long vitorias = (Long) piloto[1];
			
			String vitoriasFormatada = VencedoresUtil
					.defineCasasDecimais(Double.valueOf(vitorias), 0);
			VitoriasPorPaisDTO dto = new VitoriasPorPaisDTO(pais, vitoriasFormatada);
        	
			listaDto.add(dto);
		}
        
        em.close();
        emf.close();
		
		return listaDto;
	}
	
	public static List<VitoriasPorPaisDTO> getMediaVitoriasByPais() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        
        GenericDAO<Object[]> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p.pais, AVG(p.vitorias) FROM Piloto p "
        		+ "GROUP BY p.pais ORDER BY SUM(p.vitorias) DESC";
        List<Object[]> resultados = dao.executeQuery(jpql, Object[].class, null);
        
        List<VitoriasPorPaisDTO> listaDto = new LinkedList<>();
        for (Object[] piloto : resultados) {
        	String pais = (String) piloto[0];
			Double vitorias = (Double) piloto[1];
			
			String vitoriasFormatada = VencedoresUtil.defineCasasDecimais(vitorias, 2);
			VitoriasPorPaisDTO dto = new VitoriasPorPaisDTO(pais, vitoriasFormatada);
        	
			listaDto.add(dto);
		}
        
        em.close();
        emf.close();
		
		return listaDto;
	}

}
