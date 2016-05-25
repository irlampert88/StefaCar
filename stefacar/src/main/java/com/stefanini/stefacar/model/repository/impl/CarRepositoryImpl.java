package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.SaleCarShow;
import com.stefanini.stefacar.model.domain.Car;

@SuppressWarnings("all")
public class CarRepositoryImpl extends AbstractRepository<Car>{
	
	public List<SaleCarShow>listAllRecordsByBrand(Integer idBrand){
		
		String sql = "select c.price, m.type, c.carcolor, m.name, m.version, m.year, m.id, c.idcar "
				+ "from car as c inner join modelcar as m "
				+ "on c.idcarmodel = m.id join brandcar as b "
				+ "on m.idbrandcar = b.id "
				+ "where m.idbrandcar = "+idBrand;	
		
		List<SaleCarShow>listOfCarShow = new ArrayList<>();
		List<Object[]>listResultado = entityManager.createNativeQuery(sql).getResultList();
		if(listResultado != null){
			for (Object[] objectArray : listResultado) {
				SaleCarShow carShow = new SaleCarShow((Double)objectArray[0], (String)objectArray[1], (String)objectArray[2], 
						(String)objectArray[3], (String)objectArray[4], (String)objectArray[5], (Integer)objectArray[6], (Integer)objectArray[7]);
				listOfCarShow.add(carShow);
			}
		}
		return listOfCarShow;
	}	
}
