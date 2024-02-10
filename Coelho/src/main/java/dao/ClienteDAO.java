package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Cliente;
import models.Imovel;

public class ClienteDAO {
	
	public static List<Cliente> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT c FROM Cliente c";
        List<Cliente> clientes = dao.executeQuery(jpql, Cliente.class);
        
        em.close();
        emf.close();
		
		return clientes;
	}
	
	public static Cliente getClienteById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        Cliente cliente = dao.findById(Cliente.class, id);
        
        em.close();
        emf.close();
		
		return cliente;
	}
	
	public static Cliente getClienteByImovel(Imovel imovel) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT c FROM Cliente c "
        		+ "INNER JOIN Imovel i ON c.id = i.idCliente "
        		+ "WHERE i.id = ?";
        
        List<Cliente> clientes = dao.executeQuery(jpql, Cliente.class, imovel.getId());
        
        em.close();
        emf.close();
		
		return clientes.get(0);
	}
	
	public static Cliente save(Cliente c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        Cliente cliente = dao.save(c);
        
        em.close();
        emf.close();
		
		return cliente;
	}
	
	public static Cliente update(Cliente c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        Cliente cliente = dao.update(c);
        
        em.close();
        emf.close();
		
		return cliente;
	}
	
	public static void remove(Cliente c) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Cliente> dao = new GenericDAO<>(em);
        
        dao.remove(Cliente.class, c.getId());
        
        em.close();
        emf.close();
	}

}
