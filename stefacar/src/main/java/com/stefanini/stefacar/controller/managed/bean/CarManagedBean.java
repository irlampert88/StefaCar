package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.SystemMesenger;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.CarServiceImpl;

@ManagedBean
@ViewScoped
public class CarManagedBean {

	private Car car;
	private List<Car> listAllCars;

	@Inject
	private CarServiceImpl service;

	@Inject
	private CarRepositoryImpl repositoryCar;

	@PostConstruct
	public void init() {
		car = new Car();
		listAllCars = repositoryCar.listAllRecords();
	}

	public void save() {
		getCar().changeAvailability();
		service.save(getCar());
		SystemMesenger.notificaInformacao("Parabens!", "Cadastro de Carro salvo com sucesso!");
		loadAllCarsFromDataBase();		
		clean();
	}

	public void delete(Car Car) {
		service.delete(Car);
		SystemMesenger.notificaInformacao("Parabens!", "Cadastro de Carro excluido com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}

	public void clean() {
		setCar(new Car());
	}

	private void loadAllCarsFromDataBase() {
		setListAllCars(service.loadAllCarsFromDataBase());
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public List<Car> getListAllCars() {
		return listAllCars;
	}

	public void setListAllCars(List<Car> listAllCars) {
		this.listAllCars = listAllCars;
	}

}
