package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Login;
import com.stefanini.stefacar.model.service.impl.LoginServiceImpl;

@ManagedBean
@SessionScoped
public class LoginManagedBean {

	private Login login;
	private List<Login> listOfRegisterLogins;

	@Inject
	private LoginServiceImpl service;

	public LoginManagedBean() {
	}

	public void save() {
		service.save(getLogin());
		MessengerSystem.notificaInformacao("Parabéns!", "Login salvo com sucesso!");
		loadListOfLogins();
		clean();
	}

	public void delete(Login login) {
		service.delete(login);
		MessengerSystem.notificaInformacao("Parabéns!", "Login deletado com sucesso!");
		loadListOfLogins();
		clean();
	}

	public void clean() {
		setLogin(new Login());
	}

	private void loadListOfLogins() {
		setListOfRegisterLogins(service.loadAllLoginsFromDataBase());
	}

	public List<Login> getListOfRegisterLogins() {
		if (listOfRegisterLogins == null) {
			loadListOfLogins();
		}
		return listOfRegisterLogins;
	}

	public void setListOfRegisterLogins(List<Login> listOfRegisterLogins) {
		this.listOfRegisterLogins = listOfRegisterLogins;
	}

	public Login getLogin() {
		if (login == null) {
			clean();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}