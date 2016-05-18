package com.stefanini.stefacar.model.service.impl;


import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;

public class EmployeeServiceImpl extends AbstractService<Employee> {

	@Inject
	public EmployeeServiceImpl(EmployeeRepositoryImpl repository) {
		super(Employee.class, repository);
	}
	
}
