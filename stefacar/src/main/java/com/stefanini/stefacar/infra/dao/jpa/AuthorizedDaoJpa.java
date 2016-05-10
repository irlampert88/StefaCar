package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Authorized;

public class AuthorizedDaoJpa extends AbstractDaoJpa<Integer, Authorized> {

	@Inject
	public AuthorizedDaoJpa(EntityManager entityManager) {
		super(entityManager);

	}
}
