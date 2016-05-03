package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Provider;
import com.stefanini.stefacar.model.repository.impl.ProviderRepository;

public class ProviderService extends AbstractServiceImplementation<Provider>{
@Inject
	public ProviderService( ProviderRepository repository) {
		super(Provider.class, repository);
	
	}

}
