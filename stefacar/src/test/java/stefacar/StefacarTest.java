package stefacar;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import com.stefanini.stefacar.infra.dao.jpa.EmployeeDaoJpa;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.service.impl.EmployeeService;


public class StefacarTest {

	@InjectMocks
	private EmployeeDaoJpa employeeDaoJpa;
	
	
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void initMock() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void TestingMethodListAllRecordsFromDataBase() {
		Employee employee1 = new Employee(1, "John", "00810364000");
		Employee employee2 = new Employee(2, "Maria", "00810464000");
		List <Employee> le = new ArrayList<>();
		le.add(employee1);
		le.add(employee2);
		when(employeeService.listAllRecordsFromDataBase()).thenReturn(le);
	}


}
