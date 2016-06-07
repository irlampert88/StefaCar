package com.stefanini.stefacar.model.repository.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.repository.Repository;

@SuppressWarnings("unchecked")
public abstract class AbstractRepository<T> implements Repository<T> {
	
	@SuppressWarnings("rawtypes")
	private Class clazz = null;
	
	
	public AbstractRepository() {
		super();
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		this.clazz = (Class<T>) (type).getActualTypeArguments()[0];
	}	
	
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

	@Override
	public List<T> listAllRecords() {
		return entityManager.createQuery("select l from " + clazz.getSimpleName() + " l").getResultList();
	}
}
