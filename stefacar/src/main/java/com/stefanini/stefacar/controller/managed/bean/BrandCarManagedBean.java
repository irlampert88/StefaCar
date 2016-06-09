package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.service.impl.BrandCarServiceImpl;

@ManagedBean
@SessionScoped
public class BrandCarManagedBean {

	private BrandCar brand;
	private List<BrandCar> dataList;

	@Inject
	protected BrandCarServiceImpl service;

	@PostConstruct
	public void init() {
		brand = new BrandCar();
		dataList = service.loadAllBrandCarFromDataBase();
	}

	public void save() {
		service.save(getBrand());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca salvo com sucesso!");
		clean();
	}

	public void delete(BrandCar brand) {
		service.delete(brand);
		dataList.remove(brand);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca excluido com sucesso!");
	}

	public void setList(List<BrandCar> dataList) {
		this.dataList = dataList;
	}

	public List<BrandCar> getDataList() {
		return dataList;
	}

	public BrandCar getBrand() {
		return brand;
	}

	public void setBrand(BrandCar brand) {
		this.brand = brand;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("brandcarRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void setBrandForEdit(BrandCar brand) {
		this.brand = brand;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("brandcarRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void clean() {
		setBrand(new BrandCar());
		dataList = service.loadAllBrandCarFromDataBase();
	}
}