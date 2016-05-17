package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.SaleService;

//@SessionScoped não consegui usar o Session não subia o servidor
@ManagedBean
@ViewScoped
public class SaleManagedBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private SaleService service;
	
	@Inject
	private SaleRepositoryImpl repositorySale;
	
	@Inject
	private EmployeeRepositoryImpl repositoryEmployee;

	@Inject
	private CarRepositoryImpl repositoryCar;

	@Inject
	private ClientRepositoryImpl repositoryClient;
	
	
	private Sale sale;
	private List<Sale> listOfSales;
	private List<Employee>listOfEmployee;
	private List<Car>listOfCar;
	private List<Client>listOfClient;
	
	
	@PostConstruct
	public void init() {
		sale = new Sale();
		listOfSales = repositorySale.allSales();
		listOfEmployee = repositoryEmployee.listAllRecords();
		listOfCar = repositoryCar.allCars();
		listOfClient = repositoryClient.listAllRecords();
		
//		listOfSales = new ArrayList<>();
//		listOfEmployee = new ArrayList<>();
//		listOfCar = new ArrayList<>();
//		listOfClient = new ArrayList<>();		
	}
	
	public void save(){
		service.save(sale);
	}
	
	public void delete(Sale sale) {
		service.delete(sale);
	}
	
	public void clean(){
		sale = new Sale();
	}

	
	//--[GETTES AND SETTERS]
	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public List<Sale> getListOfSales() {
		return listOfSales;
	}

	public void setListOfSales(List<Sale> listOfSales) {
		this.listOfSales = listOfSales;
	}

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public List<Car> getListOfCar() {
		return listOfCar;
	}

	public void setListOfCar(List<Car> listOfCar) {
		this.listOfCar = listOfCar;
	}

	public List<Client> getListOfClient() {
		return listOfClient;
	}

	public void setListOfClient(List<Client> listOfClient) {
		this.listOfClient = listOfClient;
	}
}
