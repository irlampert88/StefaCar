package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.controller.warehouse.CategoryType;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.service.impl.ModelCarServiceImpl;

@ManagedBean
@ViewScoped
public class ModelCarManagedBean {

	private ModelCar modelCar;
	private List<ModelCar> dataList;

	@Inject
	protected ModelCarServiceImpl service;

	@PostConstruct
	public void init() {
		modelCar = new ModelCar();
		dataList = service.loadAllModelCarFromDataBase();
	}

	public void save() {
		service.save(getModelCar());
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo salvo com sucesso!");
		 clean();
	}

	public void delete(ModelCar modelCar) {
		service.delete(modelCar);
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo excluido com sucesso!");
	}

	public void setList(List<ModelCar> dataList) {
		this.dataList = dataList;
	}

	public List<ModelCar> getDataList() {
		return dataList;
	}

	public ModelCar getModelCar() {
		return modelCar;
	}

	public void setModelCar(ModelCar modelCar) {
		this.modelCar = modelCar;
	}
	
	public CategoryType[] getCategoryType() {
		return CategoryType.values();
	}

	public void clean() {
		setModelCar(new ModelCar());
	}
}