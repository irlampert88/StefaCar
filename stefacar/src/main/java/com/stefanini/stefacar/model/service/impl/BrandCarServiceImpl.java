package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;


public class BrandCarServiceImpl{

	@Inject
	private BrandCarRepositoryImpl repository;
	
	@Transactional
	public void save(BrandCar brandCar) {
		if (brandCar.getId() == null) {
			repository.insert(brandCar);
		} else {
			repository.update(brandCar);
		}
	}

	@Transactional
	public void delete(BrandCar brandCar) {
		repository.delete(brandCar);
	}

	@Transactional
	public List<BrandCar> loadAllBrandCarFromDataBase() {
		return repository.listAllRecords();
	}
}

