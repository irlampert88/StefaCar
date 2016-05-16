package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.*;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.SaleService;

//@SessionScoped não consegui usar o Session não subia o servidor
@Named(value= "saleManagedBean")
@ViewScoped
public class SaleManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Sale sale;
	private List<Sale> listOfSales;
	private List<Employee>listOfEmployee;
	private List<Car>listOfCar;
	private List<Client>listOfClient;
	
	
	@Inject
	private SaleService service;
	@Inject
	private SaleRepositoryImpl repositorySale;
	@Inject
	private EmployeeRepositoryImpl repositoryEmployee;
//	@Inject
//	private CarRepositoryImpl repositoryCar;
	@Inject
	private ClientRepositoryImpl repositoryClient;
	
	public SaleManagedBean() {
		listOfSales = new ArrayList<>();
		listOfEmployee = new ArrayList<>();
		listOfCar = new ArrayList<>();
		listOfClient = new ArrayList<>();
		clean();
		upLoadSaleList();
//		upLoadCarList();
		upLoadClientList();
		upLoadEmployeeList();
	}
	
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
	
	public List<Employee> getListOfEmploee() {
		return listOfEmployee;
	}

	public void setListOfEmploee(List<Employee> listOfEmploee) {
		this.listOfEmployee = listOfEmploee;
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

	private void clean(){
		sale = new Sale();
		listOfSales.clear();
		listOfCar.clear();
		listOfClient.clear();
		listOfEmployee.clear();
	}
	
	private void upLoadSaleList(){
		setListOfSales(repositorySale.allSales());
	}
	
//	private void upLoadCarList(){
//		setListOfCar(repositoryCar.allCars());
//	}
	
	private void upLoadClientList(){
		setListOfClient(repositoryClient.listAllRecords());
	}
	
	private void upLoadEmployeeList(){
		setListOfEmploee(repositoryEmployee.listAllRecords());
	}
}
