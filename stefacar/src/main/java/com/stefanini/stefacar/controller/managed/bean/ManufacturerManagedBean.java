package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Manufacturer;
import com.stefanini.stefacar.model.service.impl.ManufacturerServiceImpl;

@ManagedBean
@SessionScoped
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
		MessengerSystem.notifyInfo("Parabens!", "Cadastro de Fabricante salvo com sucesso");
		clean();
	}

	public void delete(Manufacturer manufacturer) {
		service.delete(manufacturer);
		dataList.remove(manufacturer);
		MessengerSystem.notifyInfo("Parabens!", "Cadastro de Fabricante excluido com sucesso!");
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
	public void setManufacturerForEdit(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("manufacturerRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void clean() {
		setManufacturer(new Manufacturer());
		dataList = service.loadAllManufacturerFromDataBase();
	}
}