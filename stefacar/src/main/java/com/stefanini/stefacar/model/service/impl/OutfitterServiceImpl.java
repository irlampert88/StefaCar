package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Outfitter;
import com.stefanini.stefacar.model.repository.impl.OutfitterRepository;

public class OutfitterServiceImpl {
	@Inject
	private OutfitterRepository repository;

	@Transactional
	public void save(Outfitter outfitter) {
		if (outfitter.getId() == null) {
			repository.insert(outfitter);
		} else {
			repository.update(outfitter);
		}
	}

	@Transactional
	public void delete(Outfitter outfitter) {
		repository.delete(outfitter);
	}

	@Transactional
	public List<Outfitter> loadAllOutfitterFromDataBase() {
		return repository.listAllRecords();
	}
}
