package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.controller.warehouse.EmployeeType;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.service.impl.EmployeeServiceImpl;

@ManagedBean
@ViewScoped
public class EmployeeManagedBean {

	private Employee employee;
	private List<Employee> dataList;
	
	@Inject
	protected EmployeeServiceImpl service;
	
	public EmployeeManagedBean(EmployeeServiceImpl service) {
		this.service = service;
	}

	public EmployeeManagedBean() {
	}

	public void save() {
		service.save(getEmployee());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de funcionario salvo com sucesso");
		clean();
	}

	public void delete(Employee employee) {
		service.delete(employee);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de funcionario excluido com sucesso!");
	}

	private void listAllRecords() {
		setList(service.listAllRecords());
	}

	public void setList(List<Employee> dataList) {
		this.dataList = dataList;
	}

	public List<Employee> getDataList() {
		if (dataList == null) {
			listAllRecords();
		}
		return dataList;
	}

	public Employee getEmployee() {
		if (employee == null) {
			clean();
		}
		return employee;
	}

	public void setEntity(Employee entity) {
		this.employee = entity;
	}

	public EmployeeType[] getEmployeeType() {
		return EmployeeType.values();
	}

	public void clean() {
		setEntity(new Employee());
	}
}
