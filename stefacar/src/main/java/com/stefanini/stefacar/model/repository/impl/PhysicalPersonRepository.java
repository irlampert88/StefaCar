package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.AbstractPerson;

@SuppressWarnings("all")
public class PhysicalPersonRepository extends AbstractRepositoryImplementation<AbstractPerson>{

	@Inject
	private EntityManager entityManager;
	
	public void insert(AbstractPerson abstractPerson) {
		entityManager.persist(abstractPerson);
	}
	
	public void delete(AbstractPerson abstractPerson) {
		entityManager.remove(entityManager.merge(abstractPerson));
	}

	public void update(AbstractPerson abstractPerson) {
		entityManager.merge(abstractPerson);	
	}

	public List<AbstractPerson> allRecords(Class<?> abstractPersonClass) {
		return entityManager.createQuery("select l from " + abstractPersonClass.getSimpleName() + " l").getResultList();
	}
	
	
}
