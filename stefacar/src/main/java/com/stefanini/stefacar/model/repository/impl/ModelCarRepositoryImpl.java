package com.stefanini.stefacar.model.repository.impl;


import com.stefanini.stefacar.model.domain.ModelCar;

@SuppressWarnings("all")
public class ModelCarRepositoryImpl extends AbstractRepository<ModelCar>{
	
	public ModelCar deliveryModelCar(Integer id){
		return entityManager.find(ModelCar.class, id);		
	}
	
}
