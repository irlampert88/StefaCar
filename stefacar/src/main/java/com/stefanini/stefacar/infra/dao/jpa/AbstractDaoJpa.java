package com.stefanini.stefacar.infra.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import com.stefanini.stefacar.infra.dao.AbstractDao;

@SuppressWarnings("unchecked")
public abstract class AbstractDaoJpa<PK, T> implements AbstractDao<PK, T>{

	private EntityManager entityManager;

	public AbstractDaoJpa(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
 
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    /* Utilizei clazz porque se utilizar class da erro!*/
    public Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
	
	
}
