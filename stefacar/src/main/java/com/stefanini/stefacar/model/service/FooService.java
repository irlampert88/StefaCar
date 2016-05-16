package com.stefanini.stefacar.model.service;

import com.stefanini.stefacar.model.domain.Foo;

public interface FooService {

	public Iterable<Foo> listAllFooFriends(Foo foo);
}
