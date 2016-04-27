package com.stefanini.stefacar.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class ContactList {
	List<Contact>contactList;
	
	private int type;
	private String value;
	
	public ContactList() {
		contactList = new ArrayList<>();
	}
	
	public void addContact() {
		contactList.add(new Contact(type, value));
		value = "";
	}
	
	// getter e setter
	
}
