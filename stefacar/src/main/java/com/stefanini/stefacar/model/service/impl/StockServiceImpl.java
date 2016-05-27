package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Stock;
import com.stefanini.stefacar.model.repository.impl.StockRepositoryImpl;

public class StockServiceImpl {

	@Inject
	private StockRepositoryImpl repository;
	
	@Transactional
	public void save(Stock stock){
		if (stock.getCar().getId() == null) {
			repository.insert(stock);
		} else {
			repository.update(stock);
		} 
	}
	
	@Transactional
	public void delete(Stock stock){
		repository.delete(stock);
	}
	
	@Transactional
	public List<Stock> loadAllStockCarsFromDataBase() {
		return repository.listAllRecords();		
	}
	
}
