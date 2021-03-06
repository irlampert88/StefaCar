package com.stefanini.stefacar.infra.factory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class FactoryFacesContext {
	
	@Produces @RequestScoped
	public FacesContext createFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
}
