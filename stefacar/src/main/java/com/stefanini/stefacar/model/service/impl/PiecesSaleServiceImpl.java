package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.PiecesSale;
import com.stefanini.stefacar.model.repository.impl.PiecesSaleRepositoryImpl;

public class PiecesSaleServiceImpl {
	@Inject
	private PiecesSaleRepositoryImpl repository;

	@Transactional
	public void save(PiecesSale picesSale) {
		if (picesSale.getIdSale() == null) {
			repository.insert(picesSale);
		} else {
			repository.update(picesSale);
		}
	}

	@Transactional
	public void delete(PiecesSale picesSale) {
		repository.delete(picesSale);
	}

	@Transactional
	public List<PiecesSale> loadAllPiecesSalesFromDataBase() {
		return repository.listAllRecords();
	}

}
