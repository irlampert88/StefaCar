package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;

public class EmployeeServiceImpl {

	@Inject
	private EmployeeRepositoryImpl repository;

	@Transactional
	public void save(Employee employee) {
		repository.insert(employee);

	}

	@Transactional
	public void delete(Employee employee) {
		repository.delete(employee);

	}

	@Transactional
	public List<Employee> listAllRecords(Employee employee) {
		return repository.listAllRecords(employee);
	}
}