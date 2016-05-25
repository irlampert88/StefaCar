package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.service.impl.BrandCarServiceImpl;


@ManagedBean
@ViewScoped
public class BrandCarManagedBean {

	private BrandCar brand;
	private List<BrandCar> datalist;
	
	@Inject
	protected BrandCarServiceImpl service;
	
	public BrandCarManagedBean(BrandCarServiceImpl service) {
		this.service = service;
	}

	public BrandCarManagedBean() {

	}

	public void save() {
		service.save(getBrand());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca salvo com sucesso!");
		clean();
	}

	public void delete(BrandCar brand) {
		service.delete(brand);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca excluido com sucesso!");
	}
	
	private void listAllRecords() {
		setList(service.listAllRecords());
	}

	public void setList(List<BrandCar> dataList) {
		this.datalist = dataList;
	}

	public List<BrandCar> getDataList() {
		if (datalist == null) {
			listAllRecords();
		}
		return datalist;
	}

	public BrandCar getBrand() {
		if (brand == null) {
			clean();
		}
		return brand;
	}

	public void setBrand(BrandCar brand) {
		this.brand = brand;
	}

	public void clean() {
		setBrand(new BrandCar());
	}

	
}
