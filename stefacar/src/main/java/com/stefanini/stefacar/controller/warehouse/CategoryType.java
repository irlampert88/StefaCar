package com.stefanini.stefacar.controller.warehouse;

public enum CategoryType {

	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch Médio"),
	SEDAN_COMPACTO("Sedan Compacto"),
	SEDAN_MEDIO("Sedan Médio"),
	SEDAN_GRANDE("Sedan Grande"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilitário Comercial");
	
	private String label;

    private CategoryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
	
}
