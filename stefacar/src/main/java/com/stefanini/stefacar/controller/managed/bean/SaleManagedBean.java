package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

<<<<<<< HEAD
import com.stefanini.stefacar.controller.converter.MessengerSystem;
<<<<<<< HEAD
=======
=======
import com.stefanini.stefacar.controller.shared.MessengerSystem;
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.domain.Car;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.domain.SaleCarShow;
<<<<<<< HEAD
import com.stefanini.stefacar.model.domain.Stock;
<<<<<<< HEAD
=======
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
=======
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
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
<<<<<<< HEAD
=======
//	@Inject
//	private CarRepositoryImpl repositoryCar;
=======
	@Inject
	private CarRepositoryImpl repositoryCar;
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a

>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	@Inject
	private ClientRepositoryImpl repositoryClient;
	
	@Inject
	private BrandCarRepositoryImpl repositoryBrand;
	
	@Inject
	private ModelCarRepositoryImpl repositoryModelCar;	
	
	private ModelCar modelCar;
	private Sale sale;
	private SaleCarShow carShow;
	private List<Sale> listOfSales;
	private List<Employee> listOfEmployee;
<<<<<<< HEAD
<<<<<<< HEAD
=======
//	private List<Car> listOfCar;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
=======
	private List<Car> listOfCar;
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
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
<<<<<<< HEAD
<<<<<<< HEAD
		listOfClient = repositoryClient.listAllRecords();
		listFromStock = repositoryStock.listAllRecords();
	}

	public void save() {
=======
//		listOfCar = repositoryCar.listAllRecords();
=======
		listOfCar = repositoryCar.listAllRecords();
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
		listOfClient = repositoryClient.listAllRecords();
	}

	public void save() {
		changeCarShowToCarAndSetCarInSale();
<<<<<<< HEAD
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
		service.save(sale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de Carro salvo com sucesso");
=======
		sale.getCar().changeAvailability();		
		service.save(getSale());
		MessengerSystem.notificaInformacao("Parabï¿½ns!", "Cadastro de Venda de Carro salvo com sucesso");
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
		clean();
	}

	public void delete(Sale sale) {
		service.delete(sale);
		MessengerSystem.notificaInformacao("Parabï¿½ns!", "Cadastro de Venda de Carro excluido com sucesso");
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
		sale.setCar(new Car(modelCar, carShow.getPrice(), carShow.getColor(), carShow.getIdCar()));
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

	public List<Car> getListOfCar() {
		return listOfCar;
	}

	public void setListOfCar(List<Car> listOfCar) {
		this.listOfCar = listOfCar;
	}	
}
