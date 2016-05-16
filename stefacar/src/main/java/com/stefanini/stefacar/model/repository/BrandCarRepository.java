package com.stefanini.stefacar.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.BrandCar;

public class BrandCarRepository {


	@Inject
	private EntityManager entityManager;

	public void insert(BrandCar brandCar) {
		entityManager.persist(brandCar);
	}

	public void delete(BrandCar brandCar) {
		entityManager.remove(entityManager.merge(brandCar));
	}

	public void update(BrandCar brandCar) {
		entityManager.merge(brandCar);
	}

	@SuppressWarnings("unchecked")
	public List<BrandCar> listAllRecords(BrandCar brandCar) {
		return entityManager.createQuery("select l from " + BrandCar.class.getSimpleName() + " l").getResultList();
	}

}
