package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepositoryImpl;

public class ModelCarServiceImpl{

	@Inject
	private ModelCarRepositoryImpl repository;
	
	@Transactional
	public void save(ModelCar modelCar) {
		if (modelCar.getId() == null) {
			repository.insert(modelCar);
		} else {
			repository.update(modelCar);
		}
	}

	@Transactional
	public void delete(ModelCar modelCar) {
		repository.delete(modelCar);
	}

	@Transactional
	public List<ModelCar> loadAllModelCarFromDataBase() {
		return repository.listAllRecords();
	}
}

