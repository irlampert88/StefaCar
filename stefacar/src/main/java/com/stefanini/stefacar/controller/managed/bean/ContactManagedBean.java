package com.stefanini.stefacar.controller.managed.bean;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.stefanini.stefacar.controller.warehouse.ContactType;

@Named(value="contactManagedBean")
@ViewScoped
public class ContactManagedBean {

	public ContactType[] getTypes() {
		return ContactType.values();
	}
	
}
