package com.stefanini.stefacar.model.repository.impl;

import java.util.Date;
import java.util.List;

import com.stefanini.stefacar.controller.converter.DateUtil;

import com.stefanini.stefacar.model.domain.CashRegister;

@SuppressWarnings("all")
public class CashRegisterRepositoryImpl extends AbstractRepository<CashRegister>{
	
	public boolean thereSaleOn(){
		int listTest = entityManager.createQuery("select l from " + CashRegister.class.getSimpleName() + " l").getFirstResult();
		if(listTest==0){
			return false;
		}else{
			return true;
		}
	}
	//método para testa como ta vindo a data do banco
	public String entregaDateDoBanco(){
		java.sql.Date dataSql = (java.sql.Date) entityManager.createNativeQuery("select dateOfSale from cashregister").getSingleResult();
		Date dataUtil = new Date(dataSql.getTime());
		String dataString = DateUtil.dateToString(dataUtil);
		return dataString;
	}
	
	public List<Object[]> closingPerDay(String d){//ver com o Ivan se não vale a pena criar um objeto
		String sql = "select dateofsale, (select SUM(amount)) "+ 
				"from cashregister where dateofsale = " + d +" group by dateofsale";
		return entityManager.createNativeQuery(sql).getResultList();		
	}
	
}
