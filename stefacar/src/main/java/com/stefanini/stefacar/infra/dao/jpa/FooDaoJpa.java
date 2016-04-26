package com.stefanini.stefacar.infra.dao.jpa;

import com.stefanini.stefacar.infra.dao.FooDao;
import com.stefanini.stefacar.model.domain.Foo;

public class FooDaoJpa implements FooDao {

	@Override
	public Foo findFooByName(String fooName) {
		// EntityManager query
		return null;
	}

	@Override
	public void persist(Foo newRegister) {
		// persist a new register
	}

}
