package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.domain.SaleCarShow;
import com.stefanini.stefacar.model.repository.impl.BrandCarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;

@ManagedBean
@ViewScoped
public class ResultFiltersSalesCarManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CarRepositoryImpl repository;
	
	@Inject
	BrandCarRepositoryImpl repositoryBrand;
	
	private List<BrandCar> resultBrand;
	private List<SaleCarShow> result;
	private Integer selectedBrand;
	
	@PostConstruct
	public void init(){
		result = new ArrayList<>();
		resultBrand = repositoryBrand.listAllRecordsbyOrderName();
	}
	
	public void deliveryCarByBrand(ValueChangeEvent event) {
		String teste = event.getNewValue().toString();
		selectedBrand = Integer.parseInt(teste);
		result = repository.listAllSalesByBrand(selectedBrand);
	}
	
	//GETERS & SETERS

	public List<SaleCarShow> getResult() {
		return result;
	}

	public void setResult(List<SaleCarShow> result) {
		this.result = result;
	}

	public Integer getSelectedBrand() {
		return selectedBrand;
	}

	public void setSelectedBrand(Integer selectedBrand) {
		this.selectedBrand = selectedBrand;
	}

	public List<BrandCar> getResultBrand() {
		return resultBrand;
	}

	public void setResultBrand(List<BrandCar> resultBrand) {
		this.resultBrand = resultBrand;
	}
}
