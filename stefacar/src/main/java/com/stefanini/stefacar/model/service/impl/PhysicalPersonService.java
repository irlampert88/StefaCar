package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.AbstractPerson;
import com.stefanini.stefacar.model.repository.impl.PhysicalPersonRepository;

public class PhysicalPersonService extends AbstractServiceImplementation<AbstractPerson>{

	@Inject
	public PhysicalPersonService(PhysicalPersonRepository abstractPersonRepository) {
		super(AbstractPerson.class, abstractPersonRepository);
	}

}
