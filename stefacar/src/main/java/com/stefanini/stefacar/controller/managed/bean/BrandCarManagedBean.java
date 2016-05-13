package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.BrandCar;
import com.stefanini.stefacar.model.service.BrandCarService;

@ViewScoped
@ManagedBean
public class BrandCarManagedBean {

	private BrandCar brandCar;
	private List<BrandCar> listAllBrandCars;
	
	@Inject
	private BrandCarService service;
	
	
	public BrandCarManagedBean(BrandCarService service) {
		this.service = service;
	}

	public BrandCarManagedBean() {

	}

	public void save() {
		BrandCarService.save(getBrandCar());
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully saved !");
	}

	public void delete(BrandCar brandCar) {
		BrandCarService.delete(brandCar);
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully deleted !");
	}
	
	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<BrandCar> dataList) {
		this.listAllBrandCars = dataList;
	}

	public List<BrandCar> getDataList() {
		if (listAllBrandCars == null) {
			listAllRecordsFromDataBase();
		}
		return listAllBrandCars;
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
