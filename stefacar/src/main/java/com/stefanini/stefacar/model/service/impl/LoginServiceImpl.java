package com.stefanini.stefacar.model.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.infra.dao.transactional.Transactional;
import com.stefanini.stefacar.model.domain.Login;
import com.stefanini.stefacar.model.repository.impl.LoginRepositoryImpl;

public class LoginServiceImpl {
	@Inject
	private LoginRepositoryImpl repository;

	@Transactional
	public void save(Login login) {
		if (login.getId() == null) {
			repository.insert(login);
		} else {
			repository.update(login);
		}
	}

	@Transactional
	public void delete(Login login) {
		repository.delete(login);
	}

	@Transactional
	public List<Login> loadAllLoginsFromDataBase() {
		return repository.listAllRecords();
	}
}
