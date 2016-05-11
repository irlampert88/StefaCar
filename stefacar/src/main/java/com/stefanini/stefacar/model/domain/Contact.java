package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contact {
	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}

	public ContactList getListContacts() {
		return listContacts;
	}

	public void setListContacts(ContactList listContacts) {
		this.listContacts = listContacts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idContact;
	@Column
	private String type;
	@Column
	private String value;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "listaDeContatosID")
	private ContactList listContacts;

	public Contact() {
	}

	public Contact(String type, String value) {
		this.type = type;
		this.value = value;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
