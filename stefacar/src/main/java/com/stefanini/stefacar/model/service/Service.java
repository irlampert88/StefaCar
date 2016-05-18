package com.stefanini.stefacar.model.service;

import java.util.List;

public interface Service<T> {

	public void save(T entidade);

	public void delete(T entidade);

	public List<T> listAllRecords();

}
