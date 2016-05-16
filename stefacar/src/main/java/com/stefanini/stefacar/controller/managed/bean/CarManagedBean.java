package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.SystemMesenger;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.service.impl.CarService;

@ManagedBean
@ViewScoped
public class CarManagedBean {
	
	
	private Car car;
	private List<Car> listAllCars;
	
	@Inject
	private CarService service;
	
	public CarManagedBean() {
	}
	
	public void save() {
		service.save(getCar());
		SystemMesenger.notificaInformacao("Parab�ns!", "Car salva com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}
	
	public void delete(Car Car) {
		service.delete(Car);
		SystemMesenger.notificaInformacao("Parab�ns!", "Car deletada com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}
	
	public void clean() {
		setCar(new Car());
	}
	
	private void loadAllCarsFromDataBase() {
		setListAllCars(service.loadAllCarsFromDataBase());
	}
	
	public List<Car> getListAllCars() {
		if (listAllCars == null) {
			loadAllCarsFromDataBase();
		}
		return listAllCars;
	}
	
	public void setListAllCars(List<Car> listAllCars) {
		this.listAllCars = listAllCars;
	}
	
	public Car getCar() {
		if (car == null) {
			clean();
		}
		return car;
	}
	
	public void setCar(Car Car) {
		this.car = Car;
	}

}
