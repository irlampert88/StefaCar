package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepository;

public class EmployeeService extends AbstractServiceImplementation<Employee> {
	
@Inject
	public EmployeeService(EmployeeRepository repository) {
		super(Employee.class, repository);

	}
}
