package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Provider;

@SuppressWarnings("unchecked")
public class ProviderRepository extends AbstractRepositoryImplementation<Provider> {
	@Inject
	private EntityManager entityManager;

	public void insert(Provider provider) {
		entityManager.persist(provider);
	}

	public void delete(Provider provider) {
		entityManager.remove(entityManager.merge(provider));
	}

	public void update(Provider provider) {
		entityManager.merge(provider);
	}

	public List<Provider> allRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}
}
