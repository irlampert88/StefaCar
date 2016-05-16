package com.stefanini.stefacar.infra.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FabricaDeFacesContext {
	
	@Produces @RequestScoped
	public FacesContext criarFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}
