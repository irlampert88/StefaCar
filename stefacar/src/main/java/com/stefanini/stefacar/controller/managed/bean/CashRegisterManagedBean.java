package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

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
		
	CashRegister cashregister;
	
	@PostConstruct
	public void init(){
		cashregister = new CashRegister();
		cashregister.setSales(repositorySale.listAllRecordsByActive());
	}
	
	public void closeSales(Sale sale){
		sale.setStatus(false);//venda finalizada		
	}
	
	

}
