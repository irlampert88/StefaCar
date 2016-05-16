package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepository;


public class BrandCarServiceImpl{

	@Inject
	private BrandCarRepository brandCarRepository;
	
	@Transacional
	public void save(BrandCar brandCar) {
		brandCarRepository.insert(brandCar);
		
	}

	@Transacional
	public void delete(BrandCar brandCar) {
		brandCarRepository.delete(brandCar);
		
	}
	
	@Transacional
	public List<BrandCar> listAllRecords(BrandCar brandCar) {
		return brandCarRepository.listAllRecords(brandCar);
	}
}

