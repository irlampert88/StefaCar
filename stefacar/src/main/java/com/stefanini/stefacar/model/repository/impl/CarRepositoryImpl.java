package com.stefanini.stefacar.model.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.stefanini.stefacar.model.domain.Car;
import com.stefanini.stefacar.model.domain.SaleCarShow;

@SuppressWarnings("all")
public class CarRepositoryImpl extends AbstractRepository<Car>{	
	
	public List<SaleCarShow> listAllRecordsByBrand(Integer idBrand) {

		String sql = "select c.price, m.type, c.color, m.name, m.version, m.year, m.id, c.id "
				+ "from car as c inner join modelcar as m " + "on c.model_id = m.id join brandcar as b "
				+ "on m.idbrandcar = b.id " + "where m.brand_id = " + idBrand + " and c.avaliable = 'true'";

		List<SaleCarShow> listOfCarShow = new ArrayList<>();
		List<Object[]> resultList = entityManager.createNativeQuery(sql).getResultList();
		if (resultList != null) {
			for (Object[] objectArray : resultList) {
				SaleCarShow carShow = new SaleCarShow((Double) objectArray[0], (String) objectArray[1],
						(String) objectArray[2], (String) objectArray[3], (String) objectArray[4],
						(String) objectArray[5], (Integer) objectArray[6], (Integer) objectArray[7]);
				listOfCarShow.add(carShow);
			}
		}
		return listOfCarShow;
	}
	
	public void update(Car car){
		entityManager.merge(car);
	}
		
}
