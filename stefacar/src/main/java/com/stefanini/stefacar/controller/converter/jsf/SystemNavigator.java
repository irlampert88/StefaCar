package com.stefanini.stefacar.controller.converter.jsf;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

public class SystemNavigator {

	@Inject
	private NavigationHandler navigationHandler;
	
	@Inject
	private FacesContext facesContext;
	
	public void redirecionarPara(String url) {
		navigationHandler.handleNavigation(facesContext, null, url + "?faces-redirect=true");
		facesContext.renderResponse();
	}
	
}
