package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.domain.Stock;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.StockRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.SaleServiceImpl;

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
	private ClientRepositoryImpl repositoryClient;
	
	@Inject
	private StockRepositoryImpl repositoryStock;

	private Sale sale;
	private List<Sale> listOfSales;
	private List<Employee> listOfEmployee;
	private List<Client> listOfClient;
	private List<Stock> listFromStock;

	@PostConstruct
	public void init() {
		sale = new Sale();
		listOfSales = repositorySale.listAllRecords();
		listOfEmployee = repositoryEmployee.listAllRecords();
		listOfClient = repositoryClient.listAllRecords();
		listFromStock = repositoryStock.listAllRecords();
	}

	public void save() {
		service.save(sale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de Carro salvo com sucesso");
		clean();
	}

	public void delete(Sale sale) {
		service.delete(sale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de Carro excluido com sucesso");
	}

	public void clean() {
		sale = new Sale();
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

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public List<Client> getListOfClient() {
		return listOfClient;
	}

	public void setListOfClient(List<Client> listOfClient) {
		this.listOfClient = listOfClient;
	}

	public List<Stock> getListFromStock() {
		return listFromStock;
	}

	public void setListFromStock(List<Stock> listFromStock) {
		this.listFromStock = listFromStock;
	}
	
}
