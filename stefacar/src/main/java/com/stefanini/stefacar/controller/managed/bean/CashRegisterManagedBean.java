package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

@ManagedBean
@ViewScoped
public class CashRegisterManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CashRegisterRepositoryImpl repositoryCash;
	
	@Inject
	SaleRepositoryImpl repositorySale;
		
	private CashRegister cashregister;
	private Sale saleSelected;
	@PostConstruct
	public void init(){
		cashregister = new CashRegister();
		cashregister.setSales(repositorySale.listAllRecordsByActive());
	}
	
	public void closeSales(Sale sale){
		sale.setStatus(false);//venda finalizada		
	}
	
	public void selectSale(Sale sale){
		saleSelected = sale;
	}
		
	//GETERS & SETERS
	
	public CashRegister getCashregister() {
		return cashregister;
	}

	public void setCashregister(CashRegister cashregister) {
		this.cashregister = cashregister;
	}

	public Sale getSaleSelected() {
		return saleSelected;
	}

	public void setSaleSelected(Sale saleSelected) {
		this.saleSelected = saleSelected;
	}
	
	public TypeOfPayment[] getTypeOfPayMent(){
		return TypeOfPayment.values();
	}

}
