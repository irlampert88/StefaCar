package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;

public class ClientServiceImpl extends AbstractService<Client> {
	@Inject
	public ClientServiceImpl(ClientRepositoryImpl repository) {
		super(Client.class, repository);
	}
}