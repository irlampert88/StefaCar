package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Address;

public class AddressDaoJpa extends AbstractDaoJpa<Integer, Address>{
	
	@Inject
	public AddressDaoJpa(EntityManager entityManager) {
		super(entityManager);
	}
}
