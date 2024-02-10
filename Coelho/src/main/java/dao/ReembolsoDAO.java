package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Fatura;
import models.Reembolso;

public class ReembolsoDAO {
	
	public static List<Reembolso> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Reembolso p";
        List<Reembolso> reembolsos = dao.executeQuery(jpql, Reembolso.class);
        
        em.close();
        emf.close();
		
		return reembolsos;
	}
	
	public static Reembolso getReembolsoById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        Reembolso reembolso = dao.findById(Reembolso.class, id);
        
        em.close();
        emf.close();
		
		return reembolso;
	}
	
	public static List<Reembolso> getReembolsosByFatura(Fatura f) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT r FROM Reembolso r "
        		+ "INNER JOIN Pagamento p ON r.pagamento.id = p.id "
        		+ "WHERE p.fatura.id = ?1";
        
        List<Reembolso> reembolsos = dao.executeQuery(jpql, Reembolso.class, f.getId());
        
        em.close();
        emf.close();
		
		return reembolsos;
	}
	
	public static Reembolso save(Reembolso r) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        Reembolso reembolso = dao.save(r);
        
        em.close();
        emf.close();
		
		return reembolso;
	}
	
	public static Reembolso update(Reembolso r) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        Reembolso reembolso = dao.update(r);
        
        em.close();
        emf.close();
		
		return reembolso;
	}
	
	public static void remove(Reembolso r) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Reembolso> dao = new GenericDAO<>(em);
        
        dao.remove(Reembolso.class, r.getId());
        
        em.close();
        emf.close();
	}

}
