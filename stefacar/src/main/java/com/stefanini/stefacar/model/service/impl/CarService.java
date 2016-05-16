package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.repository.impl.CarRepository;

public class CarService {
	
	@Inject
	private CarRepository repository;
	
	@Transactional
	public void save(Car car) {
		if (car.getId() == null) {
			repository.insert(car);
		} else {
			repository.update(car);
		} 
	}

	@Transactional
	public List<Car> loadAllCarsFromDataBase() {
		return repository.allCars();
	}

	@Transactional
	public void delete(Car car) {
		repository.delete(car);;
	}

}
