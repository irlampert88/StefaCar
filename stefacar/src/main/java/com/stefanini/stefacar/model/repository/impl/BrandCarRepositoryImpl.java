package com.stefanini.stefacar.model.repository.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.BrandCarDao;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.BrandCarRepository;

public class BrandCarRepositoryImpl{

	@Inject
	private BrandCarDao brandCarDao;
	
	public BrandCar findBrandCarByName(String brandCarName) {
		return brandCarDao.findBrandCarByName(brandCarName);
	}

	public void save(BrandCar newRegister) {
		fireEventBeforeSave();
		brandCarDao.persist(newRegister);
		fireEventAfterSave();
	}

	private void fireEventAfterSave() {
		// something action after save
	}

	private void fireEventBeforeSave() {
		// something action before save
	}
	
}
