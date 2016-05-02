package com.stefanini.stefacar.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class ContactList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmprestimo;
	
	@OneToMany(cascade=CascadeType.REFRESH)	
	@JoinColumn(name="idContato")
	private List<Contact>contactList;

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public ContactList() {
		
	}
}
