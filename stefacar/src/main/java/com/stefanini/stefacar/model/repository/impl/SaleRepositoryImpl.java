package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Sale;

public class SaleRepositoryImpl {
	
	@Inject
	private EntityManager entityManager;
		
	public void save(Sale newSale) {
//		fireEventBeforeSave();
		entityManager.persist(newSale);
//		fireEventAfterSave();
	}
	
	public void update(Sale sale) {
		entityManager.merge(sale);
	}
	
	public void delete(Sale sale) {
		entityManager.remove(sale);
	}
	
	private void fireEventAfterSave() {
		// something action after save
	}

	private void fireEventBeforeSave() {
		// something action before save
	}
	
	@SuppressWarnings("unchecked")
	public List<Sale>allSales(){
		return entityManager.createQuery("select s from "+Sale.class.getSimpleName() + " s").getResultList();		
	}

}
