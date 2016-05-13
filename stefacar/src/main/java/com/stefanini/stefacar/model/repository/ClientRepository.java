package com.stefanini.stefacar.model.repository;

import java.util.List;

import javax.persistence.EntityManager;

import com.stefanini.stefacar.model.domain.Client;

@SuppressWarnings("all")
public class ClientRepository {

	private EntityManager entityManager;

	public void insert(Client client) {
		entityManager.persist(client);
	}

	public void refresh(Client client) {
		entityManager.merge(client);
	}

	public void delete(Client client) {
		entityManager.remove(client);
	}

	public List<Client> allClients() {

		return entityManager.createQuery("select l from " + Client.class.getSimpleName() + " l ").getResultList();
	}

}
