package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.TabChangeEvent;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.PhysicalPerson;
import com.stefanini.stefacar.model.service.impl.PhysicalPersonService;

@ManagedBean
@ViewScoped
public class PhysicalPersonManagedBean extends AbstractManagedBeanImplementation<PhysicalPerson> {

	private PhysicalPerson person;
	@Inject
	protected PhysicalPersonService service;
	private List<PhysicalPerson> dataList;

	public PhysicalPersonManagedBean(PhysicalPersonService service) {
		this.service = service;
	}

	public PhysicalPersonManagedBean() {

	}

	@Override
	public void save() {
		service.save(getPerson());
		MessengerSystem.notificaInformacao("Parabéns!", "Nova autorizada cadastrada com sucesso");
	}

	@Override
	public void delete(PhysicalPerson person) {
		service.delete(person);
		MessengerSystem.notificaInformacao("Parabéns!", "Autorizada deletada com sucesso !");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	private void setListaDeDados(List<PhysicalPerson> list) {
		this.dataList = list;

	}

	public List<PhysicalPerson> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public void setEntity(PhysicalPerson entity) {
		this.person = entity;
	}

	public void clean() {
		setEntity(new PhysicalPerson());
	}

	public void onTabChange(TabChangeEvent event) {
		event.getTab();
	}

	public PhysicalPerson getPerson() {
		return person;
	}

	public void setPerson(PhysicalPerson person) {
		this.person = person;
	}

}
