package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Manufacturer;
import com.stefanini.stefacar.model.repository.impl.ManufacturerRepository;

public class ManufacturerServiceImpl {
	@Inject
	private ManufacturerRepository repository;

	@Transactional
	public void save(Manufacturer manufacturer) {
		if (manufacturer.getId() == null) {
			repository.insert(manufacturer);
		} else {
			repository.update(manufacturer);
		}
	}

	@Transactional
	public void delete(Manufacturer manufacturer) {
		repository.delete(manufacturer);
	}

	@Transactional
	public List<Manufacturer> loadAllManufacturerFromDataBase() {
		return repository.listAllRecords();
	}
}
