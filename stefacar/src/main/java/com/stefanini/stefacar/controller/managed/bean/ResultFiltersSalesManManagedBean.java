package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.ResultSearch;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

@ManagedBean
@ViewScoped
public class ResultFiltersSalesManManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	SaleRepositoryImpl repositorySale;
	
	private List<ResultSearch>resultList;
	
	@PostConstruct
	public void init() {
		resultList = repositorySale.listForRanking();		
	}
	
	public void upgradeRanking(){
		resultList = repositorySale.listForRanking();
	}
	
	
	//GETERS & SETERS

	public List<ResultSearch> getResultList() {
		return resultList;
	}

	public void setResultList(List<ResultSearch> resultList) {
		this.resultList = resultList;
	}
}
