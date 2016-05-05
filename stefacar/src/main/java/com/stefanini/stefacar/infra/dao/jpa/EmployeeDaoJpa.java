package com.stefanini.stefacar.infra.dao.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Employee;

public class EmployeeDaoJpa extends AbstractDaoJpa<Integer, Employee> {
	@Inject
	public EmployeeDaoJpa(EntityManager entityManager) {
		super(entityManager);

	}

}
