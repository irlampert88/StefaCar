package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import com.stefanini.stefacar.model.domain.BrandCar;
import com.sun.java.accessibility.util.java.awt.ListTranslator;

@SuppressWarnings("all")
public class BrandCarRepositoryImpl extends AbstractRepository<BrandCar> {

	public List<BrandCar> listAllRecordsbyOrderName() {
		return entityManager.createQuery("select l from " + BrandCar.class.getSimpleName() + " l order by l.name asc")
				.getResultList();
	}
}
