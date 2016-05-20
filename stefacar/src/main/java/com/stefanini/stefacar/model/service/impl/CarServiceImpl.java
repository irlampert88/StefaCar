package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;

public class CarServiceImpl{
	
	@Inject
	private CarRepositoryImpl repository;
	
	@Transactional
	public void save(Car car){
		if (car.getId() == null) {
			repository.insert(car);
		} else {
			repository.update(car);
		} 
	}
	
	@Transactional
	public void delete(Car car){
		repository.delete(car);
	}
	
	@Transactional
	public List<Car> loadAllCarsFromDataBase() {
		return repository.listAllRecords();		
	}

}
