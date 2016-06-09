package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.controller.warehouse.CategoryType;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.service.impl.ModelCarServiceImpl;

@ManagedBean
@SessionScoped
public class ModelCarManagedBean {

	private ModelCar model;
	private List<ModelCar> dataList;

	@Inject
	protected ModelCarServiceImpl service;

	@PostConstruct
	public void init() {
		model = new ModelCar();
		dataList = service.loadAllModelCarFromDataBase();
	}

	public void save() {
		service.save(getModel());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo salvo com sucesso!");
		clean();
	}

	public void delete(ModelCar model) {
		service.delete(model);
		dataList.remove(model);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Modelo excluido com sucesso!");
	}

	public void setList(List<ModelCar> dataList) {
		this.dataList = dataList;
	}

	public List<ModelCar> getDataList() {
		return dataList;
	}

	public ModelCar getModel() {
		return model;
	}

	public void setModel(ModelCar model) {
		this.model = model;
	}
	public void setModelForEdit(ModelCar model) {
		this.model = model;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("modelCarRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public CategoryType[] getCategoryType() {
		return CategoryType.values();
	}

	public void clean() {
		setModel(new ModelCar());
		dataList = service.loadAllModelCarFromDataBase();
	}
}