package com.stefanini.stefacar.model.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPerson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	public AbstractPerson(Integer idPerson, String name, ContactList contactList, Address adress) {
//		super();
//		this.idPerson = idPerson;
//		this.name = name;
//		this.contactList = contactList;
//		this.adress = adress;
//	}

	public AbstractPerson() {
		super();
		this.contactList = new ContactList();
	}

//	@Id
//	// @GeneratedValue(strategy=GenerationType.IDENTITY)
//	protected Integer idPerson;
	protected Integer idPerson;

	@Column(nullable = false)
	protected String name;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	protected ContactList contactList;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	protected Address adress;

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContactList getContactList() {
		return contactList;
	}

	public void setContactList(ContactList contactList) {
		this.contactList = contactList;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
//	 public void addContactList(Contact contact){
//	 this.contactList.addContact(); }
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
//		result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
		result = prime * result + ((contactList == null) ? 0 : contactList.hashCode());
		result = prime * result + ((idPerson == null) ? 0 : idPerson.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPerson other = (AbstractPerson) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
//		if (idPerson == null) {
//			if (other.idPerson != null)
//				return false;
//		} else if (!idPerson.equals(other.idPerson))
//			return false;
		if (contactList == null) {
			if (other.contactList != null)
				return false;
		} else if (!contactList.equals(other.contactList))
			return false;
		if (idPerson == null) {
			if (other.idPerson != null)
				return false;
		} else if (!idPerson.equals(other.idPerson))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
