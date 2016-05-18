package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.repository.impl.AbstractRepository;
import com.stefanini.stefacar.model.service.Service;

public abstract class AbstractService<T> implements Service<T> {
	private final AbstractRepository<T> repository;
	private final Class<?> entity;

	AbstractService(Class<?> entity, AbstractRepository<T> repository) {
		this.entity = entity;
		this.repository = repository;
	}

	@Transactional
	public void save(T data) {
		if (data == null) {
			repository.insert(data);
		} else {
			repository.update(data);
		}
	}

	@Transactional
	public void delete(T data) {
		repository.insert(data);

	}

	@Transactional
	public List<T> listAllRecords() {
		return repository.listAllRecords(entity);
	}

}
