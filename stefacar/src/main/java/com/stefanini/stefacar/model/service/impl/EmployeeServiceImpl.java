package com.stefanini.stefacar.model.service.impl;

import java.util.Collections;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;

public class EmployeeServiceImpl {
	
	@Inject
	private EmployeeRepositoryImpl repository;
	
	public Iterable<Employee> listAllEmployeeFromDataBase(Employee employee) {
		return Collections.emptyList();
	}
}
