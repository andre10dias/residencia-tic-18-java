package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Imovel;

public class ImovelDAO {
	
	public static List<Imovel> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT i FROM Imovel i";
        List<Imovel> imovels = dao.executeQuery(jpql, Imovel.class);
        
        em.close();
        emf.close();
		
		return imovels;
	}
	
	public static Imovel getImovelById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        Imovel imovel = dao.findById(Imovel.class, id);
        
        em.close();
        emf.close();
		
		return imovel;
	}
	
	public static List<Imovel> getImoveisComClientes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT i FROM Imovel i "
        		+ "WHERE i.cliente IS NOT NULL";
        List<Imovel> imovels = dao.executeQuery(jpql, Imovel.class);
        
        em.close();
        emf.close();
		
		return imovels;
	}
	
	public static Imovel save(Imovel i) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        Imovel imovel = dao.save(i);
        
        em.close();
        emf.close();
		
		return imovel;
	}
	
	public static Imovel update(Imovel i) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        Imovel imovel = dao.update(i);
        
        em.close();
        emf.close();
		
		return imovel;
	}
	
	public static void remove(Imovel i) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Imovel> dao = new GenericDAO<>(em);
        
        dao.remove(Imovel.class, i.getId());
        
        em.close();
        emf.close();
	}

}
