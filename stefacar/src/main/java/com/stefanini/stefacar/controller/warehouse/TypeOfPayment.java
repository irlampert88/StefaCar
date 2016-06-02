package com.stefanini.stefacar.controller.warehouse;

public enum TypeOfPayment {
	A_VISTA(1, "� vista"),
	CREDITO(2, "cart�o de cr�dito"),
	DEBITO(3, "cart�o de d�bito"),
	BOLETO(4, "boleto");
	
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
