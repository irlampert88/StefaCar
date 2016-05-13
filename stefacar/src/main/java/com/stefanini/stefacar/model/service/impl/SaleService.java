package com.stefanini.stefacar.model.service.impl;

import java.util.Collections;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Foo;
import com.stefanini.stefacar.model.domain.Sale;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

public class SaleService {
	
	@Inject
	private SaleRepositoryImpl repository;
	
	public Iterable<Sale> listAllFooFriends(Sale sale) {
		return Collections.emptyList();
	}

}
