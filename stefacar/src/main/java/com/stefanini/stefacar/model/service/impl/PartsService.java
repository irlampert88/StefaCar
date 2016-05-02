package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Parts;
import com.stefanini.stefacar.model.repository.impl.PartsRepository;

public class PartsService extends AbstractServiceImplementation<Parts> {
@Inject
	public PartsService(PartsRepository repository) {
		super(Parts.class, repository);

	}

}
