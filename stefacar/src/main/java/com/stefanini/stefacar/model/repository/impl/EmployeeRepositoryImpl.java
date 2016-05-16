package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Employee;

public class EmployeeRepositoryImpl {

	@Inject
	private EntityManager entityManager;

	public void insert(Employee employee) {
		entityManager.persist(employee);
	}

	public void delete(Employee employee) {
		entityManager.remove(entityManager.merge(employee));
	}

	public void update(Employee employee) {
		entityManager.merge(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listAllRecords(Employee employee) {
		return entityManager.createQuery("select l from " + Employee.class.getSimpleName() + " l").getResultList();
	}
}
