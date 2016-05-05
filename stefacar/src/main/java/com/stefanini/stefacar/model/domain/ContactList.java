package com.stefanini.stefacar.model.domain;

import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.stefanini.stefacar.controller.warehouse.ContactType;

@Entity
public class ContactList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContactList;
	
	@OneToMany(cascade=CascadeType.REFRESH)	
	@JoinColumn(name="idContact")
	private List<Contact> contacts;

	private ContactType type;
	private String value;
	
	
	
	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ContactList() {
		
	}
	
	public List<Contact> getContactList() {
		return Collections.unmodifiableList(contacts);
	}

	public Integer getIdContato() {
		return idContactList;
	}

	public void setIdContato(Integer idContato) {
		this.idContactList = idContato;
	}
	
	public void addContact(){
		this.contacts.add(new Contact(type, value));
		clearValues();
	}

	private void clearValues() {
		setType(null);
		setValue(null);
	}
}
