package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.AbstractPerson;

public class PhysicalPersonDaoJpa extends AbstractDaoJpa<Integer, AbstractPerson>{
	
	@Inject
	public PhysicalPersonDaoJpa(EntityManager entityManager) {
		super(entityManager);
	}
}