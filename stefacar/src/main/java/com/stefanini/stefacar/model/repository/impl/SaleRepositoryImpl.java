package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.stefanini.stefacar.controller.converter.DateUtil;
import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.ResultSearch;
import com.stefanini.stefacar.model.domain.Sale;
@SuppressWarnings("all")
public class SaleRepositoryImpl extends AbstractRepository<Sale> {
	
	public List<ResultSearch> creationProcess(List<Object[]> objectArray){
		List<ResultSearch> resultSearch = new ArrayList<>();
		if(objectArray != null){
			for (Object[] objects : objectArray) {			 
				String name = (String)objects[0];
				Double amount = (Double)objects[1];
				ResultSearch result = new ResultSearch(name, amount);
				resultSearch.add(result);
			}
		}
		return resultSearch;
	}
	
	public List<Sale> listAllRecordsByActive(){
		return entityManager.createQuery("select l from " + Sale.class.getSimpleName() + " l where progress = true").getResultList();
	}
	
	public List<ResultSearch> listForRanking(){
		String sql = "select e.name, sum(amount) from cashregister as c inner join sale as s on sale_id = s.id_sale "+ 
				"inner join employee as e on s.employee_id = e.id_employee "+
				"group by e.name order by sum(amount) desc";
		
		List<Object[]> objectList = entityManager.createNativeQuery(sql).getResultList();
		
		return creationProcess(objectList);
	}

}
