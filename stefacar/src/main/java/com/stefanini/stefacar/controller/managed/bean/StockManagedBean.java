package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.SystemMesenger;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Stock;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.StockRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.StockServiceImpl;

@ManagedBean
@ViewScoped
public class StockManagedBean {

	private Stock stock;
	private List<Car> listOfCar;
	private List<Stock> listAllCarsFromStock;

	@Inject
	private StockServiceImpl service;
	
	@Inject
	private CarRepositoryImpl repositoryCar;

	@Inject
	private StockRepositoryImpl repositoryStock;

	@PostConstruct
	public void init() {
		stock = new Stock();
		listOfCar = repositoryCar.listAllRecords();
		listAllCarsFromStock = repositoryStock.listAllRecords();
	}

	public void save() {
		getStock();
		service.save(getStock());
		SystemMesenger.notificaInformacao("Parabens!", "Cadastro salvo com sucesso!");
		loadAllCarsFromDataBase();		
		clean();
	}

	public void delete(Stock Stock) {
		service.delete(Stock);
		SystemMesenger.notificaInformacao("Parabens!", "Cadastro excluido com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}

	public void clean() {
		setCar(new Stock());
	}

	private void loadAllCarsFromDataBase() {
		setListAllCarsFromStock(service.loadAllStockCarsFromDataBase());
	}

	public Stock getStock() {
		if(stock == null){
			stock = new Stock();
			return stock;
		}
		return stock;
	}

	public void setCar(Stock stock) {
		this.stock = stock;
	}

	public List<Stock> getListAllCarsFromStock() {
		return listAllCarsFromStock;
	}

	public void setListAllCarsFromStock(List<Stock> listAllCarsFromStock) {
		this.listAllCarsFromStock = listAllCarsFromStock;
	}

	public List<Car> getListOfCar() {
		return listOfCar;
	}

	public void setListOfCar(List<Car> listOfCar) {
		this.listOfCar = listOfCar;
	}
	
	
	
}
