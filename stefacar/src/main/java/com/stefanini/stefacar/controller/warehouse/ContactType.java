package com.stefanini.stefacar.controller.warehouse;

public enum ContactType {

	HOMEPHONE(1, "Residencial"), 
	CELLPHONE(2, "Celular"), 
	BUSINESSPHONE(3, "Empresarial"), 
	EMAIL(4, "Email");

	private final int id;
	private final String name;

	private ContactType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
