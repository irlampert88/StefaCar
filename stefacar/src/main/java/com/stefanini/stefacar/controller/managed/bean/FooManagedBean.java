package com.stefanini.stefacar.controller.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.repository.FooRepository;
import com.stefanini.stefacar.model.service.FooService;

@ViewScoped
@ManagedBean
public class FooManagedBean {

	@SuppressWarnings("unused")
	@Inject
	private FooService service;
	@SuppressWarnings("unused")
	@Inject
	private FooRepository repository;

}
