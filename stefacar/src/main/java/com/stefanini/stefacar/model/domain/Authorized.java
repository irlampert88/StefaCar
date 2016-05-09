package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorized extends AbstractPerson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String AuthorizedCnpj;

	public Authorized() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorizedCnpj() {
		return AuthorizedCnpj;
	}

	public void setAuthorizedCnpj(String authorizedCnpj) {
		AuthorizedCnpj = authorizedCnpj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((AuthorizedCnpj == null) ? 0 : AuthorizedCnpj.hashCode());
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
		Authorized other = (Authorized) obj;
		if (AuthorizedCnpj == null) {
			if (other.AuthorizedCnpj != null)
				return false;
		} else if (!AuthorizedCnpj.equals(other.AuthorizedCnpj))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
