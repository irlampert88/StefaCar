package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepositoryImpl;


public class BrandCarServiceImpl{

	@Inject
	private ModelCarRepositoryImpl modelCarRepository;
	
	@Transacional
	public void save(BrandCar brandCar) {
		modelCarRepository.insert(brandCar);
		
	}

	@Transacional
	public void delete(BrandCar brandCar) {
		modelCarRepository.delete(brandCar);
		
	}
	
	@Transacional
	public List<BrandCar> listAllRecords(BrandCar brandCar) {
		return BrandCarRepositoryImpl.listAllRecords(brandCar);
	}
}

