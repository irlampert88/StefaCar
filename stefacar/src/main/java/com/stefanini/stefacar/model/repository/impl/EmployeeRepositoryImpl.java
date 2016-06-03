package com.stefanini.stefacar.model.repository.impl;


import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.model.domain.Employee;

@SuppressWarnings("all")
public class EmployeeRepositoryImpl extends AbstractRepository<Employee> {
	
	public List<Employee>listAllSalesMan(){
		String sql = "select * from employee where employee.type = 'VENDEDOR'";	
		List<Employee> listAllSalesMan = (List<Employee>)entityManager.createNativeQuery(sql).getResultList();
		return listAllSalesMan;		
	}
	
}
