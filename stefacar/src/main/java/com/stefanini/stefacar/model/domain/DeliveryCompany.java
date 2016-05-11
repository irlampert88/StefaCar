package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class DeliveryCompany extends AbstractPerson{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String cnpjDeliveryCompany;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpjDeliveryCompany() {
		return cnpjDeliveryCompany;
	}

	public void setCnpjDeliveryCompany(String cnpjDeliveryCompany) {
		this.cnpjDeliveryCompany = cnpjDeliveryCompany;
	}

	public DeliveryCompany(int id, String cnpjDeliveryCompany) {
		super();
		this.id = id;
		this.cnpjDeliveryCompany = cnpjDeliveryCompany;
	}

	public DeliveryCompany() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cnpjDeliveryCompany == null) ? 0 : cnpjDeliveryCompany.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryCompany other = (DeliveryCompany) obj;
		if (cnpjDeliveryCompany == null) {
			if (other.cnpjDeliveryCompany != null)
				return false;
		} else if (!cnpjDeliveryCompany.equals(other.cnpjDeliveryCompany))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
