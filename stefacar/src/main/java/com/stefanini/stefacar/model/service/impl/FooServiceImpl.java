package com.stefanini.stefacar.model.service.impl;

import java.util.Collections;

import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Foo;
import com.stefanini.stefacar.model.repository.FooRepository;
import com.stefanini.stefacar.model.service.FooService;

public class FooServiceImpl implements FooService {

	@Inject
	private FooRepository repository;
	
	@Override
	public Iterable<Foo> listAllFooFriends(Foo foo) {
		return Collections.emptyList();
	}

}
