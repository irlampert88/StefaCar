package com.stefanini.stefacar.model.repository;

import java.util.List;

public interface Repository<T> {

	public void insert(T data);

	public void delete(T dataDelete);

	public void update(T dataUpdate);

	public List<T> listAllRecords();

}
