package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.PhysicalPerson;
import com.stefanini.stefacar.model.repository.impl.PhysicalPersonRepository;

public class PhysicalPersonService extends AbstractServiceImplementation<PhysicalPerson> {

	@Inject
	public PhysicalPersonService(PhysicalPersonRepository personRepository) {
		super(PhysicalPerson.class, personRepository);
	}

}
