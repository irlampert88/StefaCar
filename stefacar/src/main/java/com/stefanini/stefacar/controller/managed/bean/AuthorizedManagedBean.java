package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TabChangeEvent;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Authorized;

import com.stefanini.stefacar.model.service.impl.AuthorizedService;

@Named
@ViewScoped
public class AuthorizedManagedBean extends AbstractManagedBeanImplementation<Authorized> {
	private Authorized authorized;
//	private Contact contact;
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
		MessengerSystem.notificaInformacao("Parab�ns!", "Nova autorizada cadastrada com sucesso");
	}

	@Override
	public void delete(Authorized authorized) {
		service.delete(authorized);
		MessengerSystem.notificaInformacao("Parab�ns!", "Autorizada deletada com sucesso !");
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

	// Reescrever para nao sobrecarregar get
	public Authorized getAuthorized() {
		if (authorized == null) {
			clean();
		}
		return authorized;
	}

/*	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}*/

	public void setEntity(Authorized entity) {
		this.authorized = entity;
	}

	@Override
	public void clean() {
		setEntity(new Authorized());
	}

	public void onTabChange(TabChangeEvent event) {
		event.getTab();
	}
 
	

}
