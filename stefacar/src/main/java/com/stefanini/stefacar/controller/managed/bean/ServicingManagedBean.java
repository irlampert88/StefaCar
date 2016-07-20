package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Servicing;
import com.stefanini.stefacar.model.service.impl.ServicingServiceImpl;

@ManagedBean
@SessionScoped
public class ServicingManagedBean {

	private Servicing servicing;
	private List<Servicing> dataList;
	
	@Inject
	protected ServicingServiceImpl service;

	@PostConstruct
	public void init() {
		servicing = new Servicing();
		dataList = service.loadAllServicingFromDataBase();
	}

	public void save() {
		service.save(getServicing());
		MessengerSystem.notifyInfo("Parabens!", "Cadastro de Serviços salvo com sucesso!");
		clean();
	}

	public void delete(Servicing servicing) {
		service.delete(servicing);
		dataList.remove(servicing);
		MessengerSystem.notifyInfo("Parabens!", "Cadastro de Serviços excluido com sucesso!");
	}

	public void setList(List<Servicing> dataList) {
		this.dataList = dataList;
	}

	public List<Servicing> getDataList() {
		return dataList;
	}

	public Servicing getServicing() {
		return servicing;
	}

	public void setServicing(Servicing servicing) {
		this.servicing=servicing;

	}

	public void setServicingForEdit(Servicing servicing) {
		this.servicing = servicing;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("servicingRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void clean() {
		setServicing(new Servicing());
		dataList = service.loadAllServicingFromDataBase();
	}
	
}