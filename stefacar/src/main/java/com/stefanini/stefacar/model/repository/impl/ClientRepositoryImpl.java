package com.stefanini.stefacar.model.repository.impl;

import java.util.List;

import com.stefanini.stefacar.model.domain.Client;

public class ClientRepositoryImpl extends AbstractRepository<Client> {

	private List<Client> clientList;

	@Override
	public List<Client> listAllRecords() {
		return clientList;
	}

}
