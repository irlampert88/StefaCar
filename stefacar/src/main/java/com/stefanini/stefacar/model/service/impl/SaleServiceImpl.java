package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.CarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class SaleServiceImpl {	
			
	@Inject
	private SaleRepositoryImpl repositorySale;
	
	@Inject
	private CarRepositoryImpl repositoryCar;
	
	@Transactional
	public void save(Sale sale){
		if (sale.getId() == null && sale.getCar().isAvaliable()) {
			repositorySale.insert(sale);
			sale.getCar().changeAvailability();
			repositoryCar.update(sale.getCar());
		} else {
			repositorySale.update(sale);
		} 
	}
	
	@Transactional
	public void delete(Sale sale){
		repositorySale.delete(sale);
	}
	
	@Transactional
	public List<Sale> loadAllSalesFromDataBase() {
		return repositorySale.listAllRecords();		
	}
	
	
}
