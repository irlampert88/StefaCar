//package com.stefanini.stefacar.model.service;
//
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.transaction.Transactional;
//
//import com.stefanini.stefacar.infra.dao.transactional.Transacional;
//import com.stefanini.stefacar.model.domain.BrandCar;
//import com.stefanini.stefacar.model.repository.BrandCarRepository;
//
//public class BrandCarService{
//
//	
//	@Inject
//	private static BrandCarRepository brandCarRepository;
//
//	@Transactional
//	public static void save(BrandCar brandCar){
//
//		if (brandCar.getIdBrandCar() == null) {
//			brandCarRepository.insert(brandCar);
//		} else {
//			brandCarRepository.update(brandCar);
//		}
//	}
//
//	@Transacional
//	public static List<BrandCar> loadAllBrandCarsFromDataBase() {
//		return brandCarRepository.allBrandCars();
//	}
//
//	@Transacional
//	public static void delete(BrandCar brandCar) {
//		brandCarRepository.delete(brandCar);
//	}
//
//	public List<BrandCar> listAllRecordsFromDataBase() {
//		return null;
//	}
//		
//}
