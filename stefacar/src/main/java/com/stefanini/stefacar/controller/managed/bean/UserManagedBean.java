package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.stefanini.stefacar.model.domain.User;



@SessionScoped
@ManagedBean(name="userMB")
public class UserManagedBean implements Serializable {
	public static final String INJECTION_NAME = "#{userManagedBean}";
	private static final long serialVersionUID = 1L;

	private User user;

	public boolean isAdmin() {
		return user.isAdmin();
	}

	public boolean isDefaultUser() {
		return user.isUser();
	}

	public String logOut() {
		getRequest().getSession().invalidate();
		return "/pages/public/login.xhtml";
	}

	private HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}