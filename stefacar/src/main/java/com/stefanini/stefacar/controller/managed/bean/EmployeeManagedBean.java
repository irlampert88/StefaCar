package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.service.impl.EmployeeService;

@Named
@ViewScoped
public class EmployeeManagedBean extends AbstractManagedBeanImplementation<Employee> {

	private Employee employee;
	
	@Inject
	protected EmployeeService service;
	private List<Employee> dataList;

	public EmployeeManagedBean(EmployeeService service) {
		this.service = service;
	}

	public EmployeeManagedBean() {

	}

	@Override
	public void save() {
		service.save(getParts());
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de funcionário salvo com sucesso");

	}

	@Override
	public void delete(Employee employee) {
		service.delete(employee);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de funcionário excluído com sucesso!");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<Employee> dataList) {
		this.dataList = dataList;
	}

	public List<Employee> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public Employee getParts() {
		if (employee == null) {
			clean();
		}
		return employee;
	}

	public void setEntity(Employee entity) {
		this.employee = entity;
	}

	@Override
	public void clean() {
		setEntity(new Employee());
	}

}
