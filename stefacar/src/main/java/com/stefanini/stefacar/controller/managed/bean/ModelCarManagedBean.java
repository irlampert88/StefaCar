package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.service.impl.ModelCarServiceImpl;

@ViewScoped
@ManagedBean
public class ModelCarManagedBean {


	private ModelCar modelCar;
	private List<ModelCar> dataList;

	@Inject
	protected ModelCarServiceImpl service;

	public ModelCarManagedBean(ModelCarServiceImpl service) {
		this.service = service;
	}

	public ModelCarManagedBean() {
	}

	public void save() {
		service.save(getModelCar());
		 MessengerSystem.notificaInformacao("Congratulations! " , " ModelCar successfully saved !");
	}

	public void delete(ModelCar modelCar) {
		service.delete(modelCar);
		 MessengerSystem.notificaInformacao("Congratulations! " , " ModelCar successfully deleted !");
	}

	private void listAllRecords() {
		setList(service.listAllRecords(modelCar));
	}

	public void setList(List<ModelCar> dataList) {
		this.dataList = dataList;
	}

	public List<ModelCar> getDataList() {
		if (dataList == null) {
			listAllRecords();
		}
		return dataList;
	}

	public ModelCar getModelCar() {
		if (modelCar == null) {
			clean();
		}
		return modelCar;
	}

	public void setEntity(ModelCar entity) {
		this.modelCar = entity;
	}

	public void clean() {
		setEntity(new ModelCar());
	}
}
