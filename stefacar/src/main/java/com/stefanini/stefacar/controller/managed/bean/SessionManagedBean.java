package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Login;
import com.stefanini.stefacar.model.service.impl.LoginServiceImpl;

@ManagedBean(eager = true)
@SessionScoped

public class SessionManagedBean {

	private String username;
	private String password;

	@Inject
	private Login login;
	@Inject
	private LoginServiceImpl service;

	public SessionManagedBean() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login getLogin() {
		return login;
	}

	public LoginServiceImpl getService() {
		return service;
	}

	public String login() {
		List<Login> loginListFromDB = service.loadAllLoginsFromDataBase();
		for (Login loginFromDb : loginListFromDB) {
			if (loginFromDb.getUsername().equals(username) && loginFromDb.getPassword().equals(password)) {
				this.login = loginFromDb;
				login.setLogin(true);
				if (login.getROLE_ADM() == true) {
					return "main.xhtml?faces-redirect=true";
				}
				if (login.getROLE_SALESMAN() == true) {
					return "saleRegister.xhtml?faces-redirect=true";
				}
				if (login.getROLE_MECHANIC() == true) {
					return "piecesSaleRegister.xhtml?faces-redirect=true";
				} else {
					return "main.xhtml?faces-redirect=true";
				}
			}
		}
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário e/ou senha inválidos.", null));
		return "login.xhtml?faces-redirect=true";
	}

	public String logOut() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.getExternalContext().invalidateSession();
		return "main.xhtml?faces-redirect=true";
	}

}