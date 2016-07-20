package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Servicing;
import com.stefanini.stefacar.model.repository.impl.ServicingRepositoryImpl;


public class ServicingServiceImpl{

	@Inject
	private ServicingRepositoryImpl repository;
	
	@Transactional
	public void save(Servicing servicing) {
		if (servicing.getId() == null) {
			repository.insert(servicing);
		} else {
			repository.update(servicing);
		}
	}

	@Transactional
	public void delete(Servicing servicing) {
		repository.delete(servicing);
	}

	@Transactional
	public List<Servicing> loadAllServicingFromDataBase() {
		return repository.listAllRecords();
	}

}