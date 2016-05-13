package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.service.ModelCarService;

@ViewScoped
@ManagedBean
public class ModelCarManagedBean {

	private ModelCar modelCar;
	private List<ModelCar> listAllModelCars;
	
	@Inject
	private ModelCarService service;
	
	
	public ModelCarManagedBean(ModelCarService service) {
		this.service = service;
	}

	public ModelCarManagedBean() {

	}

	public void save() {
		
		ModelCarService.save(getModelCar());
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully saved !");
	}

	public void delete(ModelCar modelCar) {
		ModelCarService.delete(modelCar);
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully deleted !");
	}
	
	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<ModelCar> dataList) {
		this.listAllModelCars = dataList;
	}

	public List<ModelCar> getDataList() {
		if (listAllModelCars == null) {
			listAllRecordsFromDataBase();
			clean();
		}
		return listAllModelCars;
	}

	public ModelCar getModelCar() {
		if (modelCar == null) {
			clean();
		}
		return modelCar;
	}

	public void setModelCar(ModelCar modelCar) {
		this.modelCar = modelCar;
	}

	public void clean() {
		setModelCar(new ModelCar());
	}

	
}
