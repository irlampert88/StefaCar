package com.stefanini.stefacar.model.repository.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.jpa.EmployeeDaoJpa;
import com.stefanini.stefacar.model.domain.Employee;

public class EmployeeRepositoryImpl {

	@Inject
	private EmployeeDaoJpa employeeDaoJpa;
	
	public Employee findByName(String name) {
		return employeeDaoJpa.findByName(name);
	}

	public void save(Employee newRegister) {
		employeeDaoJpa.persist(newRegister);
	}
 
	public void delete(Employee employee) {
		employeeDaoJpa.remove(employeeDaoJpa.merge(employee));
	}

	
}
