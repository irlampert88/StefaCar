package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;;

@Named
@ViewScoped
public abstract class AbstractManagedBeanImplementation <T> implements AbstractManagedBean<T> {

	private T address;
	protected AbstractServiceImplementation<T> service;
	private List<T> dataList;
	
	public AbstractManagedBeanImplementation(AbstractServiceImplementation<T> service) {
		this.service = service;
	}
	
	public AbstractManagedBeanImplementation(){
		
	}
	
	public void save() {
		service.save(getEntity());
		MessengerSystem.notificaInformacao("Congratulations! " , " successfully saved !");
	}
	
	public void delete(T entity) {
		service.delete(entity);
		MessengerSystem.notificaInformacao("Congratulations! " , " successfully deleted !");
	}
	
	private void listAllRecordsFromDataBase() {
		setDataList(service.listAllRecordsFromDataBase());
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public List<T> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}
	
	public T getEntity() {
		if (address == null) {
			clean();
		}
		return address;
	}
	


	public void setEntity(T entity) {
		this.address = entity;
	}
	
	
	
}
