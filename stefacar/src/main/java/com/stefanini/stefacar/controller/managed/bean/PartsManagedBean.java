package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Parts;
import com.stefanini.stefacar.model.service.impl.PartsService;

@ManagedBean
@ViewScoped
public class PartsManagedBean extends AbstractManagedBeanImplementation<Parts> {

	private Parts parts;
	@Inject
	protected PartsService service;
	private List<Parts> dataList;

	public PartsManagedBean(PartsService service) {
		this.service = service;
	}

	public PartsManagedBean() {

	}

	@Override
	public void save() {
		service.save(getParts());
		MessengerSystem.notificaInformacao("Parabéns!", "A new part was sucessfull save");

	}

	@Override
	public void delete(Parts parts) {
		service.delete(parts);
		MessengerSystem.notificaInformacao("Congrats!", " part was sucessfull delete!");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<Parts> dataList) {
		this.dataList = dataList;
	}

	public List<Parts> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public Parts getParts() {
		if (parts == null) {
			clean();
		}
		return parts;
	}

	public void setEntity(Parts entity) {
		this.parts = entity;
	}

	
	public void clean() {
		setEntity(new Parts());
	}

}