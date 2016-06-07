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
	
	public void calculatesDiscount(ValueChangeEvent event){	
		String payment = event.getNewValue().toString();
		if(payment.equals("1") || payment.equals("3")){
			discountedOrInterest = saleSelected.getCar().getPrice() * 0.9;
			calculatesTransshipment();
		}
		if(payment.equals("2")){
			discountedOrInterest = saleSelected.getCar().getPrice() * 1.3;
			calculatesTransshipment();
		}
		if(payment.equals("4")){
			double valorTotal=0;
			double parcela = saleSelected.getCar().getPrice()/24;
			for (int i = 0; i < 23; i++) {
				valorTotal += parcela * 1.3;
			}
			discountedOrInterest = valorTotal;
			calculatesTransshipment();
		}
		if(payment.equals("5")){
			double valorTotal=0;
			double parcela = saleSelected.getCar().getPrice()/36;
			for (int i = 0; i < 35; i++) {
				valorTotal += parcela * 1.3;
			}
			discountedOrInterest = valorTotal;
			calculatesTransshipment();
		}
		if(payment.equals("6")){
			double valorTotal=0;
			double parcela = saleSelected.getCar().getPrice()/48;
			for (int i = 0; i < 47; i++) {
				valorTotal += parcela * 1.3;
			}
			discountedOrInterest = valorTotal;
			calculatesTransshipment();
		}
	}
	
	private void calculatesTransshipment(){
		cashregister.setTransshipment(cashregister.getAmountPaid()-discountedOrInterest);						
	}
	
//	public void calculatesDiscount(double value, ValueChangeEvent event){	
//		String payment = event.getNewValue().toString();
//		if(payment.equals("1") || payment.equals("3")){
//			discountedOrInterest = value * 0.9; 
//		}
//		if(payment.equals("2")){
//			discountedOrInterest = value * 1.3;			 
//		}
//		if(payment.equals("4")){
//			double valorTotal=0;
//			double parcela = value/24;
//			for (int i = 0; i < 23; i++) {
//				valorTotal += parcela * 1.3;
//			}
//			discountedOrInterest = valorTotal;		
//		}
//		if(payment.equals("5")){
//			double valorTotal=0;
//			double parcela = value/36;
//			for (int i = 0; i < 35; i++) {
//				valorTotal += parcela * 1.3;
//			}
//			discountedOrInterest = valorTotal;						
//		}
//		if(payment.equals("6")){
//			double valorTotal=0;
//			double parcela = value/48;
//			for (int i = 0; i < 47; i++) {
//				valorTotal += parcela * 1.3;
//			}
//			discountedOrInterest = valorTotal;			
//		}
//	}		
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
