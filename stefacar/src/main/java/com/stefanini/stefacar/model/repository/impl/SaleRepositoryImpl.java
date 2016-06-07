package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Sale;
@SuppressWarnings("all")
public class SaleRepositoryImpl extends AbstractRepository<Sale> {
		
//	public List<Sale> listAllRecordsByActive(){
//		String sql = "select * from sale where sale.status = true";
//		List<Sale> resultList = new ArrayList<>();
//		resultList = (List<Sale>) entityManager.createNativeQuery(sql).getResultList();//se não tiver funcionando terei que fazer um lista de objects array e montar as vendas.		
//		return resultList;
//	}
	
	public List<Sale> listAllRecordsByActive(){
		return entityManager.createQuery("select l from " + Sale.class.getSimpleName() + " l where status = true").getResultList();
	}

}
