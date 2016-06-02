package com.stefanini.stefacar.model.service.impl;

import java.time.LocalDate;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class CashRegisterServiceImpl {
	
	@Inject
	private CashRegisterRepositoryImpl repositoryCashRegister;
	
	@Inject
	private SaleRepositoryImpl repositorySale;
	
	@Transactional
	public void save(CashRegister cash){					
		if(cash.getDateOfSale() == LocalDate.now()){
			repositoryCashRegister.update(cash);
			finalizesSales(cash);			
		}else{
			repositoryCashRegister.insert(cash);
			finalizesSales(cash);
		}
	}
	
	private void finalizesSales(CashRegister cash){
		for (Sale sale : cash.getSales()) {				
			if(sale.isStatus()){
				sale.setStatus(false);
				repositorySale.update(sale);
			}
		}
	}
}
