package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.service.impl.BrandCarServiceImpl;

@ManagedBean
@ViewScoped
public class BrandCarManagedBean {

	private BrandCar brandCar;
	private List<BrandCar> dataList;

	@Inject
	protected BrandCarServiceImpl service;

	@PostConstruct
	public void init() {
		brandCar = new BrandCar();
		dataList = service.loadAllBrandCarFromDataBase();
	}

	public void save() {
		service.save(getBrandCar());
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca salvo com sucesso!");
		 clean();
	}

	public void delete(BrandCar brandCar) {
		service.delete(brandCar);
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Marca excluido com sucesso!");
	}

	public void setList(List<BrandCar> dataList) {
		this.dataList = dataList;
	}

	public List<BrandCar> getDataList() {
		return dataList;
	}

	public BrandCar getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(BrandCar brandCar) {
		this.brandCar = brandCar;
	}

	public void clean() {
		setBrandCar(new BrandCar());
	}
}