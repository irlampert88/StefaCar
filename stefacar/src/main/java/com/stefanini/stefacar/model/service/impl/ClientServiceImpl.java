package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transacional;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.repository.ClientRepository;

public class ClientServiceImpl {
	@Inject
	private ClientRepository repository;

	@Transacional
	public void saveClientOnDB(Client client) {
		if (client.getId() == null) {
			repository.insert(client);
		}
		repository.refresh(client);
	}

	@Transacional
	public void deleteClient(Client client) {
		repository.delete(client);
	}

	@Transacional
	public List<Client> loadAllClientsFromDB() {
		return repository.allClients();
	}
}
