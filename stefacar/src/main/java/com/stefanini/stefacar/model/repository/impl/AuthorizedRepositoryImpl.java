package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Authorized;

@SuppressWarnings("all")
public class AuthorizedRepositoryImpl extends AbstractRepositoryImplementation<Authorized> {

	@Inject
	private EntityManager entityManager;

	public void insert(Authorized authorized) {
		entityManager.persist(authorized);
	}

	public void delete(Authorized authorized) {
		entityManager.remove(entityManager.merge(authorized));
	}

	public void update(Authorized authorized) {
		entityManager.merge(authorized);
	}

	public List<Authorized> allRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}

}
