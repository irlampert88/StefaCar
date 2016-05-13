package com.stefanini.stefacar.infra.dao;

import com.stefanini.stefacar.model.domain.BrandCar;

public interface BrandCarDao {

	public BrandCar findBrandCarByName(String brandCarName);

	public void persist(BrandCar newRegister);
}
