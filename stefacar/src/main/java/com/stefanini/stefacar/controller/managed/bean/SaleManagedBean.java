package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.SaleServiceImpl;

//@SessionScoped nÃ£o consegui usar o Session nÃ£o subia o servidor
@ManagedBean
@ViewScoped
public class SaleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private SaleServiceImpl service;

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
	private List<Employee> listOfEmployee;
	private List<Car> listOfCar;
	private List<Client> listOfClient;

	@PostConstruct
	public void init() {
		sale = new Sale();
		listOfSales = repositorySale.listAllRecords();
		listOfEmployee = repositoryEmployee.listAllRecords();
		listOfCar = repositoryCar.listAllRecords();
		listOfClient = repositoryClient.listAllRecords();

		// listOfSales = new ArrayList<>();
		// listOfEmployee = new ArrayList<>();
		// listOfCar = new ArrayList<>();
		// listOfClient = new ArrayList<>();
	}

	public void save() {
		sale.getCar().changeAvailability();
//		sale.getCar().setAvaliable(false);
		service.save(sale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de venda de carro salva com sucesso");
		clean();
	}

	public void delete(Sale sale) {
		service.delete(sale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de venda de carro salvo com sucesso");
	}

	public void clean() {
		sale = new Sale();
	}

	// --[GETTES AND SETTERS]
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
