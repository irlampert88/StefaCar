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
	//colocar uma l�gica que excluir� as vendas que n�o foram pagas ao fim do dia a l�gica a baixo est� errada 
	//fazer com que exclua as vendas que ainda est�o no caixa e n�o foram pagas ou seja cancelar as vendas
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
