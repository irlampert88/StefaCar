package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.repository.impl.CarRepository;

public class CarService {
	
	@Inject
	private CarRepository repository;
	
	@Transacional
	public void save(Car car) {
		if (car.getId() == null) {
			repository.insert(car);
		} else {
			repository.update(car);
		} 
	}

	@Transacional
	public List<Car> loadAllCarsFromDataBase() {
		return repository.allCars();
	}

	@Transacional
	public void delete(Car car) {
		repository.delete(car);;
	}

}
