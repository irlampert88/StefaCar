package com.stefanini.stefacar.infra.dao;

import java.util.List;

public interface AbstractDao <PK, T>{
	
	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public List<T> findAll();
	public Class<?> getTypeClass();
}
