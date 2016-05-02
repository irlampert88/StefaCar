package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Parts;
@SuppressWarnings("all")
public class PartsRepository extends AbstractRepositoryImplementation<Parts>{
	@Inject
	private EntityManager entityManager;
	
	public void insert(Parts parts) {
		entityManager.persist(parts);
	}
	
	public void delete(Parts parts) {
		entityManager.remove(entityManager.merge(parts));
	}

	public void update(Parts parts) {
		entityManager.merge(parts);	
	}

	public List<Parts> allRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}
}
