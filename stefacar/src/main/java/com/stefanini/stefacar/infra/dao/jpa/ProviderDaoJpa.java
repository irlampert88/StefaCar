package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Provider;

public class ProviderDaoJpa extends AbstractDaoJpa<Integer, Provider> {

	@Inject
	public ProviderDaoJpa(EntityManager entityManager) {
		super(entityManager);

	}
}
