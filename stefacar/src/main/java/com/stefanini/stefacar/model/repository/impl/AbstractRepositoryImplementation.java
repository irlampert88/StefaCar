package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.repository.AbstractRepository;

@SuppressWarnings("all")
public abstract class AbstractRepositoryImplementation<T> implements AbstractRepository<T>{
	
	@Inject
	private EntityManager entityManager;
	
	public void insert(T entity) {
		entityManager.persist(entity);
	}
	
	public void delete(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	public void update(T entity) {
		entityManager.merge(entity);	
	}

	public List<T> allRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}
	
	
}
