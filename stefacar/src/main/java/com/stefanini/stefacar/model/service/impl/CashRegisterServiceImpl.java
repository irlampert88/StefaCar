package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class CashRegisterServiceImpl {
	
	@Inject
	private CashRegisterRepositoryImpl repositoryCashRegister;
	
	@Inject
	private SaleRepositoryImpl repositorySale;
	
	@Inject
	private CarRepositoryImpl repositoryCar;
	
	@Transactional
	public void save(CashRegister cash){					
		if(cash.getId() == null){
			repositoryCashRegister.insert(cash);
//			System.out.println(repositoryCashRegister.entregaDateDoBanco());		
		}else{
			repositoryCashRegister.update(cash);			
		}
	}
	
	@Transactional
	public void closeSale(Sale sale){
		repositorySale.update(sale);		
	}	
	@Transactional
	private void finalizesCashRegister(List<Sale> sales){ 
		for (Sale sale : sales) {				
			if(sale.isProgress()){				
				repositorySale.delete(sale);
				sale.getCar().changeAvailability();
				repositoryCar.update(sale.getCar());
			}
		}
	}
}
