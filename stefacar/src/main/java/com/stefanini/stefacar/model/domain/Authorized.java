package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Authorized extends AbstractPerson {

	@Column
	private String AuthorizedCnpj;
	
	public String getAuthorizedCnpj() {
		return AuthorizedCnpj;
	}

	public void setAuthorizedCnpj(String authorizedCnpj) {
		AuthorizedCnpj = authorizedCnpj;
	}

}
