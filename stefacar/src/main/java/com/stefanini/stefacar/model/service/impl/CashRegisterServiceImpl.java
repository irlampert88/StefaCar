package com.stefanini.stefacar.model.service.impl;

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
		if(cash.getId() == null){
			repositoryCashRegister.insert(cash);
			System.out.println(repositoryCashRegister.entregaDateDoBanco());		
		}else{
			repositoryCashRegister.update(cash);			
		}
	}
	
	@Transactional
	public void closeSale(Sale sale){
		repositorySale.update(sale);		
	}
	//colocar uma lógica que excluirá as vendas que não foram pagas ao fim do dia a lógica a baixo está errada 
	//fazer com que exclua as vendas que ainda estão no caixa e não foram pagas ou seja cancelar as vendas
//	@Transactional
//	private void finalizesCashRegister(CashRegister cash){ 
//		for (Sale sale : cash.getSales()) {				
//			if(sale.isProgress()){
//				sale.setProgress(false);
//				repositorySale.update(sale);
//			}
//		}
//	}
}
