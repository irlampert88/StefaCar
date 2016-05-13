//package com.stefanini.stefacar.model.repository;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//
//import com.stefanini.stefacar.model.domain.ModelCar;
//
//public class ModelCarRepository {
//
//	@Inject
//	private EntityManager entityManager;
//	
//	public void insert(ModelCar modelCar) {
//		entityManager.persist(modelCar);
//	}
//
//	public List<ModelCar> allModelCars() {
//		return entityManager.createQuery("select l from " + ModelCar.class.getSimpleName() + " l").getResultList();
//	}
//	
//	public void delete(ModelCar modelCar) {
//		entityManager.remove(entityManager.merge(modelCar));
//	}
//
//	public void deleteModelCarById(Integer id) {
//		ModelCar entity = entityManager.find(ModelCar.class, id);
//		entityManager.remove(entity);	
//	}
//
//	public void update(ModelCar modelCar) {
//		entityManager.merge(modelCar);	
//	}
//	
//	public ModelCar findModelCarById(Integer id) {
//		return entityManager.find(ModelCar.class, id);
//	}
//
//}
