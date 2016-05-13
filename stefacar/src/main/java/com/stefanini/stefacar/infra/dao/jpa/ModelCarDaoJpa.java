package com.stefanini.stefacar.infra.dao.jpa;

import com.stefanini.stefacar.infra.dao.ModelCarDao;
import com.stefanini.stefacar.model.domain.ModelCar;

public class ModelCarDaoJpa implements ModelCarDao{

	@Override
	public ModelCar findModelCarByName(String modelCarName) {
		return null;
	}

	@Override
	public void persist(ModelCar newRegister) {
		// persist a new register
	}

	
}
