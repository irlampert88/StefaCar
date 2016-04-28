package com.stefanini.stefacar.controller.managed.bean.Impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.stefacar.controller.managed.bean.AbstractManagedBean;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;
import com.stefanini.stefacar.util.Mensageiro;

@ManagedBean
@ViewScoped
public abstract class AbstractManagedBeanImplementation <T> implements AbstractManagedBean<T> {

	protected AbstractServiceImplementation<T> service;
	private List<T> dataList;
	
	public AbstractManagedBeanImplementation(AbstractServiceImplementation<T> service) {
		this.service = service;
	}
	
	public AbstractManagedBeanImplementation(){
		
	}
	
	public void save() {
		Mensageiro.notificaInformacao("Parabéns!", "Emprestimo salvo com sucesso!");
	}
	
	public void delete(T entity) {
		service.delete(entity);
		Mensageiro.notificaInformacao("Parabéns!", "Emprestimo deletado com sucesso!");
	}
	
	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}
	
	public void setListaDeDados(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public List<T> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}
	
}
