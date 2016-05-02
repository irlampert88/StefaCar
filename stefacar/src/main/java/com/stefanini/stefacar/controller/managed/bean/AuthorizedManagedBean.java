package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Authorized;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;

@ManagedBean
@ViewScoped
public class AuthorizedManagedBean extends AbstractManagedBeanImplementation<Authorized> {
	private Authorized authorized;
	protected AbstractServiceImplementation<Authorized> service;
	private List<Authorized> dataList;

	public AuthorizedManagedBean(AbstractServiceImplementation<Authorized> service) {
		this.service = service;
	}

	public AuthorizedManagedBean() {

	}

	public void save() {
		service.save(authorized);
		MessengerSystem.notificaInformacao("Congrats!", "New athorized save sucesfull");
	}

	public void delete(Authorized authorized) {
		service.delete(authorized);
		MessengerSystem.notificaInformacao("Congrats!", "Athorized Deleted sucesfull!");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<Authorized> dataList) {
		this.dataList = dataList;
	}

	public List<Authorized> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public Authorized getAuthorized() {
		if (authorized == null) {
			clean();
		}
		return authorized;
	}

	public void setAuthorized(Authorized authorized) {
		this.authorized = authorized;
	}
	public void clean(){
		setAuthorized(new Authorized());
	}
		
}
