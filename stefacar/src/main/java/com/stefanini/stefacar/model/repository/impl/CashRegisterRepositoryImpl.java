package com.stefanini.stefacar.model.repository.impl;

import java.util.Date;
import com.stefanini.stefacar.controller.converter.DateUtil;

import com.stefanini.stefacar.model.domain.CashRegister;

public class CashRegisterRepositoryImpl extends AbstractRepository<CashRegister>{
	@SuppressWarnings("all")
	public boolean thereSaleOn(){
		int listTest = entityManager.createQuery("select l from " + CashRegister.class.getSimpleName() + " l").getFirstResult();
		if(listTest==0){
			return false;
		}else{
			return true;
		}
	}
	
	public String entregaDateDoBanco(){
		java.sql.Date dataSql = (java.sql.Date) entityManager.createNativeQuery("select data_pagamento from cashregister").getSingleResult();
		Date dataUtil = new Date(dataSql.getTime());
		String dataString = DateUtil.dateToString(dataUtil);
		return dataString;
	}
	
}
