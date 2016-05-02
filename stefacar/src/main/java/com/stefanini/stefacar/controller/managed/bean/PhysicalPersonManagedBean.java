package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.PhysicalPerson;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;

@ManagedBean
@ViewScoped
public class PhysicalPersonManagedBean extends AbstractManagedBeanImplementation<PhysicalPerson> {

	private PhysicalPerson physicalPerson;
	protected AbstractServiceImplementation<PhysicalPerson> service;
	private List<PhysicalPerson> dataList;

	public PhysicalPersonManagedBean(AbstractServiceImplementation<PhysicalPerson> service) {
		this.service = service;
	}

	public PhysicalPersonManagedBean() {

	}

	public void save() {
		service.save(getEntity());
		MessengerSystem.notificaInformacao("Parabéns!", "Emprestimo salvo com sucesso!");
	}

	public void delete(PhysicalPerson address) {
		service.delete(physicalPerson);
		MessengerSystem.notificaInformacao("Parabéns!", "Endereço deletado com sucesso!");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<PhysicalPerson> dataList) {
		this.dataList = dataList;
	}

	public List<PhysicalPerson> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public PhysicalPerson getPhysicalPerson() {
		if (physicalPerson == null) {
			clean();
		}
		return physicalPerson;
	}

	public void setPhysicalPerson(PhysicalPerson physicalPerson) {
		this.physicalPerson = physicalPerson;
	}

	public void clean() {
		setPhysicalPerson(new PhysicalPerson());
	}
}
