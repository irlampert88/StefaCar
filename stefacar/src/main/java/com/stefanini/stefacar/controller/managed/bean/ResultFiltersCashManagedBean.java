package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;

@ManagedBean
@ViewScoped
public class ResultFiltersCashManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CashRegisterRepositoryImpl repositoryCash;
	
	private List<Object[]>resultList;
	
	@PostConstruct
	public void init() {
		resultList = devolveResultado("'2016/06/16'");
		
	}
	
	public List<Object[]> devolveResultado(String teste){		
		return repositoryCash.closingPerDay(teste);
	}
	//GETERS & SETERS

	public List<Object[]> getResultList() {
		return resultList;
	}

	public void setResultList(List<Object[]> resultList) {
		this.resultList = resultList;
	}
	
	
}
