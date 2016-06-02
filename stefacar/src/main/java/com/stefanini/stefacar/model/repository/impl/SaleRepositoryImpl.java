package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.model.domain.Sale;
@SuppressWarnings("all")
public class SaleRepositoryImpl extends AbstractRepository<Sale> {
	
	public List<Sale> listAllRecordsByActive(){
		String sql = "select * from sale where sale.status = true";
		List<Sale> resultList = new ArrayList<>();
		resultList = (List<Sale>) entityManager.createNativeQuery(sql);		
		return resultList;
	}

}
