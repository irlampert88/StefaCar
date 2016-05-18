package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import com.stefanini.stefacar.model.domain.Employee;

public class EmployeeRepositoryImpl extends AbstractRepository<Employee> {

	private List<Employee> employeeList;

	@Override
	public List<Employee> listAllRecords() {
		return employeeList;
	}
}
