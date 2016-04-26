package com.stefanini.stefacar.model.repository;

import com.stefanini.stefacar.model.domain.Foo;

public interface FooRepository {

	public Foo findFooByName(String fooName);
}
