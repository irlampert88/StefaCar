package com.stefanini.stefacar.model.domain;

import java.io.Serializable;

public class ResultSearch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nameOrDate;
	private String amount;
	
	public ResultSearch(String name, String amount) { 
		this.nameOrDate = name;
		this.amount = amount;
	}
	
	public ResultSearch() {
		
	}
	
	//GETERS & SETERS
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNameOrDate() {
		return nameOrDate;
	}

	public void setNameOrDate(String nameOrDate) {
		this.nameOrDate = nameOrDate;
	}
	

}
