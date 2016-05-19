package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class SaleServiceImpl {	
			
	@Inject
	private SaleRepositoryImpl repository;
	
	@Transactional
	public void save(Sale sale){
		if (sale.getIdSale() == null) {
			repository.insert(sale);
		} else {
			repository.update(sale);
		} 
	}
	
	@Transactional
	public void delete(Sale sale){
		repository.delete(sale);
	}
	
	@Transactional
	public List<Sale> loadAllSalesFromDataBase() {
		return repository.listAllRecords();		
	}
}
