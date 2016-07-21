package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.CashRegisterPieces;
import com.stefanini.stefacar.model.domain.PiecesSale;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.CashRegisterPiecesRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.PiecesRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.PiecesSaleRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class CashRegisterPiecesServiceImpl {
	@Inject
	private CashRegisterPiecesRepositoryImpl repositoryCashRegister;
	
	@Inject
	private PiecesSaleRepositoryImpl repositorySale;
	
	@Transactional
	public void save(CashRegisterPieces cash){					
		if(cash.getId() == null){
			repositoryCashRegister.insert(cash);
		}else{
			repositoryCashRegister.update(cash);			
		}
	}
	
	@Transactional
	public void closeSale(PiecesSale sale){
		repositorySale.update(sale);		
	}	
	@Transactional
	public void finalizesCashRegister(List<PiecesSale> sales){ 
		for (PiecesSale sale : sales) {				
			if(sale.isProgress()){				
				repositorySale.delete(sale);		
			}
		}
	}
}
