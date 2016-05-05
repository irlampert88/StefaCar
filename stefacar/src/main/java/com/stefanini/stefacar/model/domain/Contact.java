package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stefanini.stefacar.controller.warehouse.ContactType;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class Contact {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idContact;	
	@Column
	private ContactType type;		
	@Column
	private String value;	
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="listaDeContatosID")
	private ContactList listContacts;	

	public Contact() {
	}
	
	public Contact(ContactType type, String value) {
	}

	public Integer getId() {
		return idContact;
	}

	public void setId(Integer id) {
		this.idContact = id;
	}

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
}
