package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepository;

public class ModelCarServiceImpl{

	@Inject
	private ModelCarRepository modelCarRepository;
	
	@Transactional
	public void save(ModelCar modelCar) {
		modelCarRepository.insert(modelCar);
		
	}

	@Transactional
	public void delete(ModelCar modelCar) {
		modelCarRepository.delete(modelCar);
		
	}
	
	@Transactional
	public List<ModelCar> listAllRecords(ModelCar modelCar) {
		return modelCarRepository.listAllRecords(modelCar);
	}
}

