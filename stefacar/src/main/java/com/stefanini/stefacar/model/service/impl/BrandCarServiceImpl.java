package com.stefanini.stefacar.model.service.impl;

import java.util.Collections;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.repository.BrandCarRepository;


public class BrandCarServiceImpl {

	@Inject
	private BrandCarRepository brandCarrepository;
	
	public Iterable<BrandCar> listAllModelCarFriends(BrandCar modelCar) {
		return Collections.emptyList();
	}

	public BrandCarRepository getBrandCarrepository() {
		return brandCarrepository;
	}

	public void setBrandCarrepository(BrandCarRepository brandCarrepository) {
		this.brandCarrepository = brandCarrepository;
	}

}

