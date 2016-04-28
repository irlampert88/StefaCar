package com.stefanini.stefacar.model.service;

import java.util.List;

public interface AbstractService <T>{
	
	public void save(T entidade);
	public void delete(T entidade);
	public List<T> listAllRecordsFromDataBase();
	
}
