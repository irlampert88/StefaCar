package com.stefanini.stefacar.infra.dao.jpa;

import com.stefanini.stefacar.infra.dao.BrandCarDao;
import com.stefanini.stefacar.model.domain.BrandCar;

public class BrandCarDaoJpa implements BrandCarDao{

	@Override
	public BrandCar findBrandCarByName(String brandCarName) {
		return null;
	}

	@Override
	public void persist(BrandCar newRegister) {
		// persist a new register
	}

	
}
