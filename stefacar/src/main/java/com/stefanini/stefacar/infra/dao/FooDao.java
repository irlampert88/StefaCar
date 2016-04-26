package com.stefanini.stefacar.infra.dao;

import com.stefanini.stefacar.model.domain.Foo;

public interface FooDao {

	public Foo findFooByName(String fooName);

	public void persist(Foo newRegister);
}
