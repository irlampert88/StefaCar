package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepository;

public class ModelCarServiceImpl{

	@Inject
	private ModelCarRepository modelCarRepository;
	
	@Transacional
	public void save(ModelCar modelCar) {
		modelCarRepository.insert(modelCar);
		
	}

	@Transacional
	public void delete(ModelCar modelCar) {
		modelCarRepository.delete(modelCar);
		
	}
	
	@Transacional
	public List<ModelCar> listAllRecords(ModelCar modelCar) {
		return modelCarRepository.listAllRecords(modelCar);
	}
}

