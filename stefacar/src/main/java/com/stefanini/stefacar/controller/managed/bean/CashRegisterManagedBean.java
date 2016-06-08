package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.CashRegisterServiceImpl;

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
	
	@Inject
	CashRegisterServiceImpl service;
		
	private CashRegister cashregister;
	private Sale saleSelected;
	private double discountedOrInterest;
	
	@PostConstruct
	public void init(){
		cashregister = new CashRegister();
		saleSelected = new Sale();
		cashregister.setSales(repositorySale.listAllRecordsByActive());
	}
	
	public void closeSales(Sale sale){
		sale.setStatus(false);//venda finalizada	
		service.closeSale(sale);
	}
	
	public void calculatesDiscount(){
		discountedOrInterest = cashregister.getTypePayment().calculateFinalValue(saleSelected.getCar().getPrice());
		calculatesTransshipment();
	}
	
	private void calculatesTransshipment(){
		cashregister.setTransshipment(cashregister.getAmountPaid()-discountedOrInterest);						
	}
	
	//GETERS & SETERS
	public double getDiscountedValue() {
		return discountedOrInterest;
	}

	public void setDiscountedValue(double discountedValue) {
		this.discountedOrInterest = discountedValue;
	}

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
