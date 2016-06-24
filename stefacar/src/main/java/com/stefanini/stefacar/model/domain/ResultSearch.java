package com.stefanini.stefacar.model.domain;

import java.io.Serializable;

public class ResultSearch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nameOrDate;
	private Double amount;
	
	public ResultSearch(String name, Double amount) { 
		this.nameOrDate = name;
		this.amount = amount;
	}
	
	public ResultSearch() {
		
	}
	
	//GETERS & SETERS
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNameOrDate() {
		return nameOrDate;
	}

	public void setNameOrDate(String nameOrDate) {
		this.nameOrDate = nameOrDate;
	}
	

}
