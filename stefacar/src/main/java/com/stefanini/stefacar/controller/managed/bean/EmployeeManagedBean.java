package com.stefanini.stefacar.controller.managed.bean;

import javax.inject.Inject;

import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.EmployeeServiceImpl;

public class EmployeeManagedBean {
	
	@Inject
	private EmployeeServiceImpl service;
	
	@Inject
	private EmployeeRepositoryImpl repository;
	
}
