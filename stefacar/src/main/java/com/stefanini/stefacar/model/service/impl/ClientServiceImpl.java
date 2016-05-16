package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;

public class ClientServiceImpl {

	@Inject
	private ClientRepositoryImpl repository;

	@Transactional
	public void save(Client client) {
		repository.insert(client);

	}

	@Transactional
	public void delete(Client client) {
		repository.delete(client);

	}

	@Transactional
	public List<Client> listAllRecords() {
		return repository.listAllRecords();
	}
}