package com.stefanini.stefacar.controller.managed.bean;

public interface AbstractManagedBean <T>{
	
	public void save();
	public void delete(T entity);

}
