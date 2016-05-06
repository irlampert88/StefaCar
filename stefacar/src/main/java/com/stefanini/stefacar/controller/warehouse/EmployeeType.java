package com.stefanini.stefacar.controller.warehouse;

public enum EmployeeType {
	ATENDENTE("Atendente"), 
	VENDEDOR("Vendedor"), 
	GERENTE("Gerente");
	
	private String label;

    private EmployeeType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
