//package com.stefanini.stefacar.model.repository;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//
//import com.stefanini.stefacar.model.domain.BrandCar;
//
//public class BrandCarRepository {
//
//	@Inject
//	private EntityManager entityManager;
//	
//	public void insert(BrandCar brandCar) {
//		entityManager.persist(brandCar);
//	}
//
//	public List<BrandCar> allBrandCars() {
//		return entityManager.createQuery("select l from " + BrandCar.class.getSimpleName() + " l").getResultList();
//	}
//	
//	public void delete(BrandCar brandCar) {
//		entityManager.remove(entityManager.merge(brandCar));
//	}
//
//	public void deleteBrandCarById(Integer id) {
//		BrandCar entity = entityManager.find(BrandCar.class, id);
//		entityManager.remove(entity);	
//	}
//
//	public void update(BrandCar brandCar) {
//		entityManager.merge(brandCar);	
//	}
//	
//	public BrandCar findBrandCarById(Integer id) {
//		return entityManager.find(BrandCar.class, id);
//	}
//
//}
