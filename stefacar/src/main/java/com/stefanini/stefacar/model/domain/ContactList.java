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
	private List<Contact> contactList;
	@Transient
	private Contact contact;
	

	public ContactList() {
		this.contactList=new ArrayList<>();
		this.contact = new Contact();
	}
	
//	public List<Contact> getContactList() {
//		return Collections.unmodifiableList(contactList);
//	}
	

	public Integer getIdContato() {
		return idContactList;
	}

	public Integer getIdContactList() {
		return idContactList;
	}

	public void setIdContactList(Integer idContactList) {
		this.idContactList = idContactList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public void setIdContato(Integer idContato) {
		this.idContactList = idContato;
	}
	
	public void addContact(){
		this.contactList.add(contact); //contact
		clearValues();
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	private void clearValues() {
		this.contact = new Contact();
	}
}
