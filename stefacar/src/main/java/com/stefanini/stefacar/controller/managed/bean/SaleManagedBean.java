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
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.domain.SaleCarShow;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepository;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepository;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.SaleServiceImpl;

//@SessionScoped não consegui usar o Session não subia o servidor
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
	
	@Inject
	private BrandCarRepository repositoryBrand;
	
	@Inject
	private ModelCarRepository repositoryModelCar;
	
	private ModelCar modelCar;
	private Sale sale;
	private SaleCarShow carShow;
	private List<Sale> listOfSales;
	private List<Employee> listOfEmployee;
	private List<Car> listOfCar;
	private List<Client> listOfClient;
	private List<BrandCar> listOfBrand;
	private Integer selectedBrand;
	private List<SaleCarShow> listOfCarWhereBrandSelected;

	@PostConstruct
	public void init() {
		modelCar = new ModelCar();
		sale = new Sale();
		carShow = new SaleCarShow();
		listOfCarWhereBrandSelected = new ArrayList<>();
		listOfBrand = repositoryBrand.listAllRecords();
		listOfSales = repositorySale.listAllRecords();
		listOfEmployee = repositoryEmployee.listAllRecords();
		listOfCar = repositoryCar.listAllRecords();
		listOfClient = repositoryClient.listAllRecords();
	}

	public void save() {
		sale.getCar().changeAvailability();
		changeCarShowToCarAndSetCarInSale();
		service.save(sale);
		MessengerSystem.notificaInformacao("Parab�ns!", "Cadastro de venda de carro salva com sucesso");
		clean();
	}

	public void delete(Sale sale) {
		service.delete(sale);
		MessengerSystem.notificaInformacao("Parab�ns!", "Cadastro de venda de carro salvo com sucesso");
	}

	public void clean() {
		modelCar = new ModelCar();
		sale = new Sale();
		carShow = new SaleCarShow();
	}
	
	public void deliveryCarByBrand(ValueChangeEvent event){
		String teste = event.getNewValue().toString();
		selectedBrand = Integer.parseInt(teste); 
		listOfCarWhereBrandSelected = repositoryCar.listAllRecordsByBrand(selectedBrand);
	}
	
	public void changeCarShowToCarAndSetCarInSale(){
		modelCar = repositoryModelCar.deliveryModelCar(carShow.getIdModel());
		Car temporaryCar = new Car(modelCar, carShow.getPrice(), carShow.getColor(), carShow.getIdCar());
		sale.setCar(temporaryCar);
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

	public List<BrandCar> getListOfBrand() {
		return listOfBrand;
	}

	public void setListOfBrand(List<BrandCar> listOfBrand) {
		this.listOfBrand = listOfBrand;
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
	
	
}
