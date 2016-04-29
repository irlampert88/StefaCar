package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Authorized;
import com.stefanini.stefacar.model.repository.impl.AuthorizedRepositoryImpl;

public class AuthorizedService extends AbstractServiceImplementation<Authorized> {

	@Inject
	public AuthorizedService(AuthorizedRepositoryImpl authorizedRepo) {
		super(Authorized.class, authorizedRepo);
	}

}
