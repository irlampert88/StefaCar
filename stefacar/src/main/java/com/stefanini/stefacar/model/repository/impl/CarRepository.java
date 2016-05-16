package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Car;

@SuppressWarnings("all")
public class CarRepository {
	
	@Inject
	private EntityManager entityManager;
	
	public void insert(Car car) {
		entityManager.persist(car);
	}

	public List<Car> allCars() {
		return entityManager.createQuery("select l from " + Car.class.getSimpleName() + " l").getResultList();
	}
	
	public void delete(Car car) {
		entityManager.remove(entityManager.merge(car));
	}

	public void deleteCarById(Integer id) {
		Car entity = entityManager.find(Car.class, id);
		entityManager.remove(entity);	
	}

	public void update(Car car) {
		entityManager.merge(car);	
	}
	
	public Car findCarById(Integer id) {
		return entityManager.find(Car.class, id);
	}

}
