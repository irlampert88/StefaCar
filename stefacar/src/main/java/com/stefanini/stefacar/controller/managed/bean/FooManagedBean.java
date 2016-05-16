package com.stefanini.stefacar.controller.managed.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.repository.FooRepository;
import com.stefanini.stefacar.model.service.FooService;

@ViewScoped
@ManagedBean
public class FooManagedBean {

	@Inject
	private FooService service;
	@Inject
	private FooRepository repository;
	
}
