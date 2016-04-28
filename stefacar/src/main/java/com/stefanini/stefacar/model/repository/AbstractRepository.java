package com.stefanini.stefacar.model.repository;

import java.util.List;


public interface AbstractRepository <T>{
	
	public void insert(T entity);
	public void delete(T entity);
	public void update(T entity);
	public List<T> allRecords(Class<?> entityClass);

}
