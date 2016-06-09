package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.controller.warehouse.EmployeeType;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.EmployeeServiceImpl;

@ManagedBean
@SessionScoped
public class EmployeeManagedBean {

	private Employee employee;
	private List<Employee> dataList;

	private List<Employee> salesman;

	@Inject
	protected EmployeeServiceImpl service;

	@Inject
	private EmployeeRepositoryImpl repositoryEmployee;

	@PostConstruct
	public void init() {
		employee = new Employee();
		dataList = service.loadAllEmployeeFromDataBase();
	}

	public void save() {
		service.save(getEmployee());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Funcionario salvo com sucesso");
		clean();
	}

	public void delete(Employee employee) {
		service.delete(employee);
		dataList.remove(employee);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Funcionario excluido com sucesso!");
	}

	public void setList(List<Employee> dataList) {
		this.dataList = dataList;
	}

	public List<Employee> getDataList() {
		return dataList;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmployeeForEdit(Employee employee) {
		this.employee = employee;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("employeeRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public List<Employee> getSalesman() {
		if (salesman == null) {
			salesman = repositoryEmployee.listAllSalesMan();
		}
		return salesman;
	}

	public void setSalesman(List<Employee> salesman) {
		this.salesman = salesman;
	}

	public EmployeeType[] getEmployeeType() {
		return EmployeeType.values();
	}

	public void clean() {
		setEmployee(new Employee());
		dataList = service.loadAllEmployeeFromDataBase();
	}
}
