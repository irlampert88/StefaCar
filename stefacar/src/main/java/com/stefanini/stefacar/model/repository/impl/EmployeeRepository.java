package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Employee;

@SuppressWarnings("all")
public class EmployeeRepository extends AbstractRepositoryImplementation<Employee>{
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

	public List<Employee> allRecords(Class<?> entityClass) {
		return entityManager.createQuery("select l from " + entityClass.getSimpleName() + " l").getResultList();
	}
}
