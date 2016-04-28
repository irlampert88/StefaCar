package com.stefanini.stefacar.model.service.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Address;
import com.stefanini.stefacar.model.repository.impl.AddressRepository;

public class AddressService extends AbstractServiceImplementation<Address>{

	@Inject
	public AddressService(AddressRepository addressRepository) {
		super(Address.class, addressRepository);
	}

}
