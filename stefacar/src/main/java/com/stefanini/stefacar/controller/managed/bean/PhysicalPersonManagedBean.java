package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.TabChangeEvent;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.AbstractPerson;
import com.stefanini.stefacar.model.domain.PhysicalPerson;
import com.stefanini.stefacar.model.service.impl.PhysicalPersonService;

@ManagedBean
@ViewScoped
public class PhysicalPersonManagedBean extends AbstractManagedBeanImplementation<PhysicalPerson> {

	private PhysicalPerson physicalPerson;
	@Inject
	protected PhysicalPersonService service;
	private List<AbstractPerson> dataList;

	public PhysicalPersonManagedBean(PhysicalPersonService service) {
		this.service = service;
	}

	public PhysicalPersonManagedBean() {

	}

	public void save() {
		service.save(getPhysicalPerson());
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully saved !");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<AbstractPerson> list) {
		this.dataList = list;
	}

	public PhysicalPerson getPhysicalPerson() {
		if (physicalPerson == null) {
			clean();
		}
		return physicalPerson;
	}

	public void setEntity(PhysicalPerson entity) {
		this.physicalPerson = entity;
	}
	@Override
	public void clean() {
		setEntity(new PhysicalPerson());
	}
	public void onTabChange(TabChangeEvent event) {  
		event.getTab();
	} 
}
