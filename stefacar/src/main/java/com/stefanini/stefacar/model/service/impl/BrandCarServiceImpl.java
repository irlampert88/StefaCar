package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepository;


public class BrandCarServiceImpl{

	@Inject
	private BrandCarRepository brandCarRepository;
	
	@Transactional
	public void save(BrandCar brandCar) {
		brandCarRepository.insert(brandCar);
		
	}

	@Transactional
	public void delete(BrandCar brandCar) {
		brandCarRepository.delete(brandCar);
		
	}
	
	@Transactional
	public List<BrandCar> listAllRecords(BrandCar brandCar) {
		return brandCarRepository.listAllRecords(brandCar);
	}
}

