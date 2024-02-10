package dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import models.Pagamento;

public class PagamentoDAO {
	
	public static List<Pagamento> getAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Pagamento> dao = new GenericDAO<>(em);
        
        String jpql = "SELECT p FROM Pagamento p";
        List<Pagamento> pagamentos = dao.executeQuery(jpql, Pagamento.class);
        
        em.close();
        emf.close();
		
		return pagamentos;
	}
	
	public static Pagamento getPagamentoById(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Pagamento> dao = new GenericDAO<>(em);
        
        Pagamento pagamento = dao.findById(Pagamento.class, id);
        
        em.close();
        emf.close();
		
		return pagamento;
	}
	
	public static Pagamento save(Pagamento p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Pagamento> dao = new GenericDAO<>(em);
        
        Pagamento pagamento = dao.save(p);
        
        em.close();
        emf.close();
		
		return pagamento;
	}
	
	public static Pagamento update(Pagamento p) throws SQLException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(GenericDAO.PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        GenericDAO<Pagamento> dao = new GenericDAO<>(em);
        
        Pagamento pagamento = dao.update(p);
        
        em.close();
        emf.close();
		
		return pagamento;
	}

}
