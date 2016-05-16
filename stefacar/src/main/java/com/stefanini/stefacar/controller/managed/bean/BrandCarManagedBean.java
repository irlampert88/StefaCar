package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.service.impl.BrandCarServiceImpl;

@ViewScoped
@javax.annotation.ManagedBean
public class BrandCarManagedBean {

	private BrandCar brandCar;
	private List<BrandCar> datalist;
	
	@Inject
	protected BrandCarServiceImpl service;
	
	public BrandCarManagedBean(BrandCarServiceImpl service) {
		this.service = service;
	}

	public BrandCarManagedBean() {

	}

	public void save() {
		service.save(getBrandCar());
		MessengerSystem.notificaInformacao("Congratulations! " , " BrandCar successfully saved !");
	}

	public void delete(BrandCar brandCar) {
		service.delete(brandCar);
		MessengerSystem.notificaInformacao("Congratulations! " , " BrandCar successfully deleted !");
	}
	
	private void listAllRecords() {
		setList(service.listAllRecords(brandCar));
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

	public BrandCar getBrandCar() {
		if (brandCar == null) {
			clean();
		}
		return brandCar;
	}

	public void setBrandCar(BrandCar brandCar) {
		this.brandCar = brandCar;
	}

	public void clean() {
		setBrandCar(new BrandCar());
	}

	
}
