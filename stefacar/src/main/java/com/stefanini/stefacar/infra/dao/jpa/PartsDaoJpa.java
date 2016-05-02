package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Parts;

public class PartsDaoJpa extends AbstractDaoJpa<Integer, Parts> {
	@Inject
	public PartsDaoJpa(EntityManager entityManager) {
		super(entityManager);

	}

}
