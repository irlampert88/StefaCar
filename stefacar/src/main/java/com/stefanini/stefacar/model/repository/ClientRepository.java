package com.stefanini.stefacar.model.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Client;

public class ClientRepository {

	@Inject
	private EntityManager entityManager;

	public void insert(Client client) {
		entityManager.persist(client);
	}

	public void delete(Client client) {
		entityManager.remove(entityManager.merge(client));
	}

	public void update(Client client) {
		entityManager.merge(client);
	}

	@SuppressWarnings("unchecked")
	public List<Client> listAllRecords(Client client) {
		return entityManager.createQuery("select l from " + Client.class.getSimpleName() + " l").getResultList();
	}
}
