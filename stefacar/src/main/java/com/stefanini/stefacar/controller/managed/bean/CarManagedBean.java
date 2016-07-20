package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.CarServiceImpl;

@ManagedBean
@SessionScoped
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
		// getCar().setAvaliable(true);
		service.save(getCar());
		MessengerSystem.notifyInfo("Parab�ns!", "Cadastro de Carro salvo com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}

	public void delete(Car Car) {
		service.delete(Car);
		listAllCars.remove(car);
		MessengerSystem.notifyInfo("Parab�ns!", "Cadastro de Carro excluido com sucesso!");
		loadAllCarsFromDataBase();
		clean();
	}

	public void clean() {
		setCar(new Car());
		listAllCars = repositoryCar.listAllRecords();
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

	public void setCarForEdit(Car car) {
		this.car = car;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("carRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public List<Car> getListAllCars() {
		return listAllCars;
	}

	public void setListAllCars(List<Car> listAllCars) {
		this.listAllCars = listAllCars;
	}

}
