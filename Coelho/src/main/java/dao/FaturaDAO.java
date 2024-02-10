package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Fatura;
import models.Imovel;

public class FaturaDAO {
	
	public static List<Fatura> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT f FROM Fatura f";
        List<Fatura> faturas = dao.executeQuery(jpql, Fatura.class);
        
        em.close();
        emf.close();
		
		return faturas;
	}
	
	public static Fatura getFaturaById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        Fatura fatura = dao.findById(Fatura.class, id);
        
        em.close();
        emf.close();
		
		return fatura;
	}
	
	public static List<Fatura> getFaturasQuitadas(Boolean isFaturaQuitada) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT f FROM Fatura f "
        		+ "WHERE f.quitada = ?1";
        List<Fatura> faturas = dao.executeQuery(jpql, Fatura.class, isFaturaQuitada);
        
        em.close();
        emf.close();
		
		return faturas;
	}
	
	public static List<Fatura> getFaturasByImovel(Imovel imovel, Boolean isFaturaQuitada) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        Map<String, Object> params = new HashMap<>();
        
        String jpql = "SELECT f FROM Fatura f "
        		+ "INNER JOIN Imovel i ON f.imovel.id = i.id "
        		+ "WHERE i.id = :idImovel ";
        		
		if (isFaturaQuitada != null) {
			jpql += "AND f.quitada = :isQuitada ";
			params.put("isQuitada", isFaturaQuitada);
		}
		
		jpql += "ORDER BY f.id";
		

        params.put("idImovel", imovel.getId());
		
        List<Fatura> faturas = dao.executeQueryParams(jpql, Fatura.class, params);
        
        em.close();
        emf.close();
		
		return faturas;
	}
	
	public static Fatura save(Fatura f) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        Fatura fatura = dao.save(f);
        
        em.close();
        emf.close();
		
		return fatura;
	}
	
	public static Fatura update(Fatura f) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        Fatura fatura = dao.update(f);
        
        em.close();
        emf.close();
		
		return fatura;
	}
	
	public static void remove(Fatura f) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Fatura> dao = new GenericDAO<>(em);
        
        dao.remove(Fatura.class, f.getId());
        
        em.close();
        emf.close();
	}

}
