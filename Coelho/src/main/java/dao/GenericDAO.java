package dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {
	
	protected static final String PERSISTENCE_UNIT = "unit_coelho_cloud";
	private final EntityManager entityManager;

    protected GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected T save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entity;
    }

    protected T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        return entity;
    }

    protected void remove(Class<T> clazz, Object id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        T entity = entityManager.find(clazz, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
        
        transaction.commit();
    }

    protected T findById(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }
    
    protected List<T> executeQuery(String jpql, Class<T> clazz) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        return query.getResultList();
    }
    
    protected List<T> executeQuery(String jpql, Class<T> clazz, Object... parametros) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        
        for (int i = 0; i < parametros.length; i++) {
            query.setParameter(i + 1, parametros[i]);
        }
        
        return query.getResultList();
    }
    
    protected List<T> executeQueryParams(String jpql, Class<T> clazz, Map<String, Object> parametros) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        
        for (Map.Entry<String, Object> entry : parametros.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        return query.getResultList();
    }


}