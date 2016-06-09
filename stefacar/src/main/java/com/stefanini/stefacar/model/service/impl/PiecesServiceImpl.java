package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Pieces;
import com.stefanini.stefacar.model.repository.impl.PiecesRepositoryImpl;

public class PiecesServiceImpl {
	@Inject
	private PiecesRepositoryImpl repository;

	@Transactional
	public void save(Pieces pieces) {
		if (pieces.getId() == null) {
			repository.insert(pieces);
		} else {
			repository.update(pieces);

		}
	}

	@Transactional
	public void delete(Pieces pieces) {
		repository.delete(pieces);
	}

	@Transactional
	public List<Pieces> loadAllPiecesFromDataBase() {
		return repository.listAllRecords();
	}
}
