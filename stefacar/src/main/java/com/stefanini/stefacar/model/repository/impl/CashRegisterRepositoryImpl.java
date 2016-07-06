package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.NumberFormat;
import com.stefanini.stefacar.controller.converter.DateUtil;
import com.stefanini.stefacar.model.domain.CashRegister;
import com.stefanini.stefacar.model.domain.ResultSearch;

@SuppressWarnings("all")
public class CashRegisterRepositoryImpl extends AbstractRepository<CashRegister> {

	public boolean thereSaleOn() {
		int listTest = entityManager.createQuery("select l from " + CashRegister.class.getSimpleName() + " l")
				.getFirstResult();
		if (listTest == 0) {
			return false;
		} else {
			return true;
		}
	}

	// método para testa como ta vindo a data do banco
	public String entregaDateDoBanco() {
		java.sql.Date dataSql = (java.sql.Date) entityManager.createNativeQuery("select dateOfSale from cashregister")
				.getSingleResult();
		Date dataUtil = new Date(dataSql.getTime());
		String dataString = DateUtil.dateToString(dataUtil);
		return dataString;
	}
	
	public List<ResultSearch> creationProcess(List<Object[]> objectArray){
		List<ResultSearch> resultSearch = new ArrayList<>();
		if(objectArray != null){
			for (Object[] objects : objectArray) {
				Date date = (Date)objects[0];
				String dateOfSale = DateUtil.dateToString(date);
				Double amount = (Double)objects[1];
				System.out.println(NumberFormat.getCurrencyInstance().format(amount));
				ResultSearch result = new ResultSearch(dateOfSale, NumberFormat.getCurrencyInstance().format(amount));
				resultSearch.add(result);
			}
		}
		return resultSearch;
	}

	public List<ResultSearch> closingPerDay(String d) {
		String sql = "select dateofsale, (select SUM(amount)) " + "from cashregister where dateofsale = " + "'" + d
				+ "'" + " group by dateofsale";		
		
		List<Object[]> objectList = entityManager.createNativeQuery(sql).getResultList();
				
		return creationProcess(objectList);
	}

	public List<ResultSearch> closingPerPeriod(String d1, String d2) {
		String sql = "select dateofsale, (select SUM(amount)) " + "from cashregister where dateofsale between " + "'"
				+ d1 + "'" + " and " + "'" + d2 + "'" + " group by dateofsale";
		
		List<Object[]> objectList = entityManager.createNativeQuery(sql).getResultList();
		
		return creationProcess(objectList);
	}
	
	public List<ResultSearch> closingPerMonth(String month, String year){
		String sql = "select dateofsale, (select SUM(amount)) " + "from cashregister where extract(month from dateofsale) = "
				+ month +" and extract(year from dateofsale) = "+ year + " group by dateofsale";
		
		List<Object[]> objectList = entityManager.createNativeQuery(sql).getResultList();
		
		return creationProcess(objectList);
	}
	
	public List<ResultSearch> closingPerYear(String year){
		String sql = "select dateofsale, (select SUM(amount)) from cashregister where extract(year from dateofsale) = "
				+ year + " group by dateofsale";
		
		List<Object[]> objectList = entityManager.createNativeQuery(sql).getResultList();
		
		return creationProcess(objectList); 
	}	
}
