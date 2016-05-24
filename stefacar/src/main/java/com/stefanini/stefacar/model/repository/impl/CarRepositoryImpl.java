package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.Car;

@SuppressWarnings("all")
public class CarRepositoryImpl extends AbstractRepository<Car>{
	
	public List<Car>listAllRecordsByBrand(Integer idBrand){

		String sql = "select c.price, m.type, c.carcolor, m.name, m.version, m.year "
				+ "from car as c inner join modelcar as m "
				+ "on c.idcarmodel = m.id join brandcar as b "
				+ "on m.idbrandcar = b.id "
				+ "where m.idbrandcar = "+idBrand;		
		
		return entityManager.createNativeQuery(sql).getResultList();
	}
}
