package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.repository.impl.AbstractRepositoryImplementation;
import com.stefanini.stefacar.model.service.AbstractService;

public abstract class AbstractServiceImplementation <T> implements AbstractService<T>{
	
	private final AbstractRepositoryImplementation<T> repository;
	private final Class<?> entityClass;
	
	public AbstractServiceImplementation(Class<?> entityClass, AbstractRepositoryImplementation<T> repository) {
		this.entityClass = entityClass;
		this.repository = repository;
	}

	@Transacional
	public void save (T entity){
		if (entity == null) {
			repository.insert(entity);
		}else{
			repository.update(entity);
		}
	}
	
	@Transacional
	public List<T> listAllRecordsFromDataBase() {
		return (List<T>) repository.allRecords(entityClass);
	}
	
	@Transacional
	public void delete(T entity){
		repository.delete(entity);
	}
	
}
