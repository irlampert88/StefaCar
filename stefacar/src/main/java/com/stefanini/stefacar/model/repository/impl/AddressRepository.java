package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Address;

@SuppressWarnings("all")
public class AddressRepository extends AbstractRepositoryImplementation<Address>{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public void insert(Address address) {
		entityManager.persist(address);
	}
	
	@Override
	public void delete(Address address) {
		entityManager.remove(entityManager.merge(address));
	}
	
	@Override
	public void update(Address address) {
		entityManager.merge(address);	
	}
	
	@Override
	public List<Address> allRecords(Class<?> addressClass) {
		return entityManager.createQuery("select l from " + addressClass.getSimpleName() + " l").getResultList();
	}
	
	
}
