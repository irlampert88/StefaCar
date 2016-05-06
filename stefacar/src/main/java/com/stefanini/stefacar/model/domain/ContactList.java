package com.stefanini.stefacar.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ContactList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContactList;
	
	@OneToMany(cascade=CascadeType.REFRESH)	
	@JoinColumn(name="idContact")
	private List<Contact> contacts;
	@Transient
	private Contact contact;
	

	public ContactList() {
		this.contacts=new ArrayList<>();
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
		this.contacts.add(contact); //contact
		clearValues();
	}

	private void clearValues() {
		this.contact = new Contact();
	}
}
