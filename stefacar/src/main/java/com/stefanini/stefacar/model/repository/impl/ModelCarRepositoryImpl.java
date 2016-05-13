package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.domain.ModelCar;

public class ModelCarRepositoryImpl {

	@Inject
	private EntityManager entityManager;

	public void insert(ModelCar modelCar) {
		entityManager.persist(modelCar);
	}

	public void delete(ModelCar modelCar) {
		entityManager.remove(entityManager.merge(modelCar));
	}

	public void update(ModelCar modelCar) {
		entityManager.merge(modelCar);
	}

	@SuppressWarnings("unchecked")
	public List<ModelCar> listAllRecords(ModelCar modelCar) {
		return entityManager.createQuery("select l from " + ModelCar.class.getSimpleName() + " l").getResultList();
	}


	
	
}