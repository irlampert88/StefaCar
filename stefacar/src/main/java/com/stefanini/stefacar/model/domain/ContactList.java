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
	private Integer idContato;
	
	@OneToMany(cascade=CascadeType.REFRESH)	
	@JoinColumn(name="idContato")
	private List<Contact>contactList;

	public ContactList() {
		
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}
	
	public void addContactInList(Contact contact){
		this.contactList.add(contact);
	}
}
