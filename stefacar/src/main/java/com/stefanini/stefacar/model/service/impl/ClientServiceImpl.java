package com.stefanini.stefacar.model.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;

public class ClientServiceImpl {
	@Inject
	private ClientRepositoryImpl repository;

	public Iterable<Client> listAllFooFriends(Client client) {
		return Collections.emptyList();
	}

	@Transactional
	public void save(Client client) {
		if (client.getId() == null) {
			repository.insert(client);
		} else {
			repository.update(client);
		}
	}

	@Transactional
	public void delete(Client client) {
		repository.delete(client);
	}

	@Transactional
	public List<Client> loadAllSalesFromDataBase() {
		return repository.listAllRecords();
	}
}