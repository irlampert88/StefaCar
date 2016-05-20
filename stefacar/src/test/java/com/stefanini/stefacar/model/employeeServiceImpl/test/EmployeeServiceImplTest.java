package com.stefanini.stefacar.model.employeeServiceImpl.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import com.stefanini.stefacar.controller.warehouse.EmployeeType;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.EmployeeServiceImpl;


public class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeRepositoryImpl employeeRepository;
	
	
	@Mock
	private EmployeeServiceImpl employeeService;
	
	@Before
	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void TestingMethodListAllRecordsFromDataBase() {
		Employee employee1 = new Employee(1, "John", "00810364000", "5190005000", "john@ju.com", 555, EmployeeType.ATENDENTE);
		Employee employee2 = new Employee(2, "Maria", "00810464000", "5190005055", "maria@ju.com", 444, EmployeeType.MECANICO);
		List <Employee> le = new ArrayList<>();
		le.add(employee1);
		le.add(employee2);
		when(employeeService.loadAllEmployeeFromDataBase()).thenReturn(le);
	}

}
