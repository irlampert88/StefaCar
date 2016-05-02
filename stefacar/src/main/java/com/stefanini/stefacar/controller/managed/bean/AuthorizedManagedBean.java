package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Authorized;
import com.stefanini.stefacar.model.service.impl.AuthorizedService;

@ManagedBean
@ViewScoped
public class AuthorizedManagedBean extends AbstractManagedBeanImplementation<Authorized> {
	private Authorized authorized;
	@Inject
	protected AuthorizedService service;
	private List<Authorized> dataList;

	public AuthorizedManagedBean(AuthorizedService service) {
		this.service = service;
	}

	public AuthorizedManagedBean() {

	}
@Override
	public void save() {

		service.save(getAuthorized());
		MessengerSystem.notificaInformacao("Congrats!", "New athorized save sucesfull");

		service.save(authorized);
		MessengerSystem.notificaInformacao("Congrats!", "New athorized save sucesfull");

	}
@Override
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

	public void setEntity(Authorized entity) {
		this.authorized = entity;
	}
	@Override
	public void clean() {
		setEntity(new Authorized());
	}

}