package com.stefanini.stefacar.controller.warehouse;

public enum CategoryType {

	HATCH_COMPACTO("Hatch Compacto"),
	HATCH_MEDIO("Hatch M�dio"),
	SEDAN_COMPACTO("Sedan Compacto"),
	SEDAN_MEDIO("Sedan M�dio"),
	SEDAN_GRANDE("Sedan Grande"),
	MINIVAN("Minivan"),
	ESPORTIVO("Esportivo"),
	UTILITARIO_COMERCIAL("Utilit�rio Comercial");
	
	private String label;

    private CategoryType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
	
}
