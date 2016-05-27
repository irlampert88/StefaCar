package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;

import com.stefanini.stefacar.model.domain.Manufacturer;

import com.stefanini.stefacar.model.service.impl.ManufacturerServiceImpl;

@ManagedBean
@ViewScoped
public class ManufacturerManagedBean {

	private Manufacturer manufacturer;
	private List<Manufacturer> dataList;

	@Inject
	protected ManufacturerServiceImpl service;

	@PostConstruct
	public void init() {
		manufacturer = new Manufacturer();
		dataList = service.loadAllManufacturerFromDataBase();
	}

	public void save() {
		service.save(getManufacturer());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Fabricante salvo com sucesso");
		clean();
	}

	public void delete(Manufacturer manufacturer) {
		service.delete(manufacturer);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Fabricante excluido com sucesso!");
	}

	public void setList(List<Manufacturer> dataList) {
		this.dataList = dataList;
	}

	public List<Manufacturer> getDataList() {
		return dataList;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void clean() {
		setManufacturer(new Manufacturer());
	}
}