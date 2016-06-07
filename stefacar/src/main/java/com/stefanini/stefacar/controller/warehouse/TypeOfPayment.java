package com.stefanini.stefacar.controller.warehouse;

public enum TypeOfPayment {
	A_VISTA(1, "dinheiro"),
	CREDITO(2, "cart�o de cr�dito 3x"),
	DEBITO(3, "cart�o de d�bito"),
	BOLETO24(4, "boleto 24X"),
	BOLETO36(5, "boleto 36X"),
	BOLETO48(6, "boleto 48X");
	
	private Integer id;
	private String label;
	
	public Integer getId(){
		return this.id;
	}
	
	public String getLabel(){
		return this.label;
	}
	
	private TypeOfPayment(Integer id, String label) {
		this.id = id;
		this.label = label;
	}

}
