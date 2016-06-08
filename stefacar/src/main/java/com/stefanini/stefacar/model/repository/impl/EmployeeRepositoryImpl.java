package com.stefanini.stefacar.model.repository.impl;


import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.model.domain.Employee;

@SuppressWarnings("all")
public class EmployeeRepositoryImpl extends AbstractRepository<Employee> {
	
	public List<Employee> listAllSalesMan(){
		return entityManager.createQuery("select l from " + Employee.class.getSimpleName() + " l where type = 'VENDEDOR'").getResultList();
	}
	
}
