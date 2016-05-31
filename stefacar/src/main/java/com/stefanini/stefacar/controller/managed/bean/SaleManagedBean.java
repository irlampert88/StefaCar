package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
<<<<<<< HEAD
=======
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.domain.Car;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.domain.SaleCarShow;
import com.stefanini.stefacar.model.domain.Stock;
<<<<<<< HEAD
=======
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepository;
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

<<<<<<< HEAD
=======
//	@Inject
//	private CarRepositoryImpl repositoryCar;

>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	@Inject
	private ClientRepositoryImpl repositoryClient;
	
	@Inject
	private BrandCarRepositoryImpl repositoryBrand;
	
	@Inject
	private ModelCarRepository repositoryModelCar;
	
	@Inject
	private StockRepositoryImpl repositoryStock;
	
	private ModelCar modelCar;
	private Sale sale;
	private SaleCarShow carShow;
	private List<Sale> listOfSales;
	private List<Employee> listOfEmployee;
<<<<<<< HEAD
=======
//	private List<Car> listOfCar;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	private List<Client> listOfClient;
	private List<BrandCar> listOfBrand;
	private Integer selectedBrand;
	private List<SaleCarShow> listOfCarWhereBrandSelected;
	private List<Stock> listOfStock;

	@PostConstruct
	public void init() {
		modelCar = new ModelCar();
		sale = new Sale();
		carShow = new SaleCarShow();
		listOfCarWhereBrandSelected = new ArrayList<>();
		listOfBrand = repositoryBrand.listAllRecords();
		listOfSales = repositorySale.listAllRecords();
		listOfEmployee = repositoryEmployee.listAllRecords();
<<<<<<< HEAD
		listOfClient = repositoryClient.listAllRecords();
		listFromStock = repositoryStock.listAllRecords();
	}

	public void save() {
=======
//		listOfCar = repositoryCar.listAllRecords();
		listOfClient = repositoryClient.listAllRecords();
		listOfStock = repositoryStock.listAllRecords();
	}

	public void save() {
		sale.getStock().getCar().changeAvailability();
		changeCarShowToCarAndSetCarInSale();
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
		service.save(sale);
		MessengerSystem.notificaInformacao("Parab�ns!", "Cadastro de Venda de Carro salvo com sucesso");
		clean();
	}

	public void delete(Sale sale) {
		service.delete(sale);
		MessengerSystem.notificaInformacao("Parab�ns!", "Cadastro de Venda de Carro excluido com sucesso");
	}

	public void clean() {
		modelCar = new ModelCar();
		sale = new Sale();
		carShow = new SaleCarShow();
	}
	
	public void deliveryCarByBrand(ValueChangeEvent event){
		String teste = event.getNewValue().toString();
		selectedBrand = Integer.parseInt(teste); 
		listOfCarWhereBrandSelected = repositoryStock.listAllRecordsByBrand(selectedBrand);
	}
	
	public void changeCarShowToCarAndSetCarInSale(){
		modelCar = repositoryModelCar.deliveryModelCar(carShow.getIdModel());
		Car temporaryCar = new Car(modelCar, carShow.getPrice(), carShow.getColor(), carShow.getIdCar());
		sale.getStock().setCar(temporaryCar);
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

<<<<<<< HEAD
	public List<Client> getListOfClient() {
		return listOfClient;
=======
	public void setListOfClient(List<Client> listOfClient) {
		this.listOfClient = listOfClient;
	}

	public List<BrandCar> getListOfBrand() {
		return listOfBrand;
	}

	public void setListOfBrand(List<BrandCar> listOfBrand) {
		this.listOfBrand = listOfBrand;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	}

	public Integer getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(Integer selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public List<SaleCarShow> getListOfCarWhereBrandSelected() {
		return listOfCarWhereBrandSelected;
	}

	public void setListOfCarWhereBrandSelected(List<SaleCarShow> listOfCarWhereBrandSelected) {
		this.listOfCarWhereBrandSelected = listOfCarWhereBrandSelected;
	}

	public SaleCarShow getCarShow() {
		return carShow;
	}

	public void setCarShow(SaleCarShow carShow) {
		this.carShow = carShow;
	}
	
	public List<Stock> getListFromStock() {
		return listOfStock;
	}

	public void setListFromStock(List<Stock> listFromStock) {
		this.listOfStock = listFromStock;
	}	
}
