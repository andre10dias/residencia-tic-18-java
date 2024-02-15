package com.formula1.vencedoresformula1.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {
	
	public static final String PERSISTENCE_UNIT = "unit_formula1";
	private final EntityManager entityManager;

    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T save(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        return entity;
    }

    public T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
        return entity;
    }

    public void remove(Class<T> clazz, Object id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        
        T entity = entityManager.find(clazz, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
        
        transaction.commit();
    }

    public T findById(Class<T> clazz, Object id) {
        return entityManager.find(clazz, id);
    }
    
    public List<T> executeQuery(String jpql, Class<T> clazz,  Integer maxResults) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        if (maxResults != null) {
			query.setMaxResults(maxResults);
		}
        
        return query.getResultList();
    }
    
    public List<T> executeQuery(String jpql, Class<T> clazz, Integer maxResults, Object... parametros) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        if (maxResults != null) {
			query.setMaxResults(maxResults);
		}
        
        for (int i = 0; i < parametros.length; i++) {
            query.setParameter(i + 1, parametros[i]);
        }
        
        return query.getResultList();
    }
    
    public List<T> executeQueryParams(String jpql, Class<T> clazz, Integer maxResults, Map<String, Object> parametros) {
        TypedQuery<T> query = entityManager.createQuery(jpql, clazz);
        if (maxResults != null) {
			query.setMaxResults(maxResults);
		}
        
        for (Map.Entry<String, Object> entry : parametros.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        
        return query.getResultList();
    }

}
