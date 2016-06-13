package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

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

	private CashRegister cashRegister;
	private List<Sale>saleList;
	private double discountedOrInterest;

	@PostConstruct
	public void init() {
		cashRegister = new CashRegister();		
		saleList = repositorySale.listAllRecordsByActive();
	}

	public void closeSales() {
		cashRegister.getSale().setProgress(false);// venda finalizada
		service.closeSale(cashRegister.getSale());
		cashRegister.setAmount(discountedOrInterest);		
		service.save(cashRegister);
		RequestContext.getCurrentInstance().execute("location.reload()");
	}

	public void calculatesDiscount(ValueChangeEvent event) {
		TypeOfPayment payment = (TypeOfPayment) event.getNewValue();
		this.cashRegister.setTypePayment(payment);
		discountedOrInterest = cashRegister.getTypePayment().calculateFinalValue(cashRegister.getSale().getCar().getPrice());
	}
	
	public TypeOfPayment[] getTypeOfPayMent() {
		return TypeOfPayment.values();
	}
	
	public void calculatesTransshipment() {
		cashRegister.setTransshipment(cashRegister.getAmountPaid() - discountedOrInterest);
	}
	
	public void upgradeSales(){
		saleList = repositorySale.listAllRecordsByActive();		
	}
	
	public void selectedSale(Sale sale){
		cashRegister.setSale(sale);
		RequestContext.getCurrentInstance().execute("PF('dialogCloseSales').show()");
	}
	

//		GETERS & SETERS	

	public CashRegister getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
	}

	public List<Sale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}

	public double getDiscountedOrInterest() {
		return discountedOrInterest;
	}

	public void setDiscountedOrInterest(double discountedOrInterest) {
		this.discountedOrInterest = discountedOrInterest;
	}
}
