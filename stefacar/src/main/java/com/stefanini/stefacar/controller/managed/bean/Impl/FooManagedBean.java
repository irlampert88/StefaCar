package com.stefanini.stefacar.controller.managed.bean.Impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.ContactList;
import com.stefanini.stefacar.model.repository.FooRepository;
import com.stefanini.stefacar.model.service.FooService;

@ViewScoped
@ManagedBean
public class FooManagedBean {

	@Inject
	private FooService service;
	@Inject
	private FooRepository repository;
	

	private ContactList contacts = new ContactList();
	
	public void salvaCliente() {
		// cliente.setContacts(getContacts());
	}
	
	public ContactList getContacts() {
		return contacts;
	}
	
	public void setContacts(ContactList contacts) {
		this.contacts = contacts;
	}	
	

}
