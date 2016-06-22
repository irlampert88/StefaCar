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
		return entityManager.createQuery("select l from " + Sale.class.getSimpleName() + " l where progress = true").getResultList();
	}
	
	public List<Object[]> listForRanking(){
		String sql = "select e.name, sum(amount) from cashregister as c inner join sale as s on sale_id = s.id_sale "+ 
				"inner join employee as e on s.employee_id = e.id_employee "+
				"group by e.name order by sum(amount) desc";
		return entityManager.createNativeQuery(sql).getResultList();
	}

}
