package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import com.stefanini.stefacar.model.domain.PiecesSale;

public class PiecesSaleRepositoryImpl extends AbstractRepository<PiecesSale> {

	@SuppressWarnings("all")
	public List<PiecesSale> listAllRecordsByActive() {
		return entityManager
				.createQuery("select l from " + PiecesSale.class.getSimpleName() + " l where progress = true")
				.getResultList();
	}

}
