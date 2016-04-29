package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authorized {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAuthorized;
	@Column
	private String authorizedName;
	@Column
	private String AuthorizedCnpj;

	// @Column
	// private ContactList authorizedContactList;
	// @Column
	// private Endress endress;
	public int getIdAuthorized() {
		return idAuthorized;
	}

	public void setIdAuthorized(int idAuthorized) {
		this.idAuthorized = idAuthorized;
	}

	public String getAuthorizedName() {
		return authorizedName;
	}

	public void setAuthorizedName(String authorizedName) {
		this.authorizedName = authorizedName;
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
		int result = 1;
		result = prime * result + ((AuthorizedCnpj == null) ? 0 : AuthorizedCnpj.hashCode());
		result = prime * result + ((authorizedName == null) ? 0 : authorizedName.hashCode());
		result = prime * result + idAuthorized;
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
		Authorized other = (Authorized) obj;
		if (AuthorizedCnpj == null) {
			if (other.AuthorizedCnpj != null)
				return false;
		} else if (!AuthorizedCnpj.equals(other.AuthorizedCnpj))
			return false;
		if (authorizedName == null) {
			if (other.authorizedName != null)
				return false;
		} else if (!authorizedName.equals(other.authorizedName))
			return false;
		if (idAuthorized != other.idAuthorized)
			return false;
		return true;
	}

}
