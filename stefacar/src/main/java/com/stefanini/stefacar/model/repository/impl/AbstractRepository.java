package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.repository.Repository;

public abstract class AbstractRepository<T> implements Repository<T> {
	@Inject
	protected EntityManager entityManager;

	@Override
	public void insert(T data) {
		entityManager.persist(data);
	}

	@Override
	public void delete(T data) {
		entityManager.remove(entityManager.merge(data));
	}

	@Override
	public void update(T data) {
		entityManager.merge(data);
	}

	@SuppressWarnings("unchecked")
	public List<T> listAllRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}
}
