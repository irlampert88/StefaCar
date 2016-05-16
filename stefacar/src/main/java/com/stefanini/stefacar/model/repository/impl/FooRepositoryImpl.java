package com.stefanini.stefacar.model.repository.impl;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.FooDao;
import com.stefanini.stefacar.model.domain.Foo;
import com.stefanini.stefacar.model.repository.FooRepository;

public class FooRepositoryImpl implements FooRepository {

	@Inject
	private FooDao fooDao;
	
	@Override
	public Foo findFooByName(String fooName) {
		return fooDao.findFooByName(fooName);
	}

	public void save(Foo newRegister) {
		fireEventBeforeSave();
		fooDao.persist(newRegister);
		fireEventAfterSave();
	}

	private void fireEventAfterSave() {
		// something action after save
	}

	private void fireEventBeforeSave() {
		// something action before save
	}
	
}
