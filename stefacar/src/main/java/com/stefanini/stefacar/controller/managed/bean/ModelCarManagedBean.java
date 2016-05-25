package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.controller.warehouse.CategoryType;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.service.impl.ModelCarServiceImpl;

@ViewScoped
@ManagedBean
public class ModelCarManagedBean {


	private ModelCar model;
	private List<ModelCar> dataList;

	@Inject
	protected ModelCarServiceImpl service;

	public ModelCarManagedBean(ModelCarServiceImpl service) {
		this.service = service;
	}

	public ModelCarManagedBean() {
	}

	public void save() {
		service.save(getModel());
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo salvo com sucesso!");
		 clean();
	}

	public void delete(ModelCar model) {
		service.delete(model);
		 MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo excluido com sucesso!");
	}

	private void listAllRecords() {
		setList(service.listAllRecords(model));
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

	public ModelCar getModel() {
		if (model == null) {
			clean();
		}
		return model;
	}

	public void setModel(ModelCar model) {
		this.model = model;
	}

	public void clean() {
		setModel(new ModelCar());
	}
	
	public CategoryType[] getCategoryType() {
		return CategoryType.values();
	}

}
