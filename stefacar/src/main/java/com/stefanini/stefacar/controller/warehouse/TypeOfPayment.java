package com.stefanini.stefacar.controller.warehouse;

public enum TypeOfPayment {
	A_VISTA(1, "à vista"),
	CREDITO(2, "cartão de crédito"),
	DEBITO(3, "cartão de débito"),
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
