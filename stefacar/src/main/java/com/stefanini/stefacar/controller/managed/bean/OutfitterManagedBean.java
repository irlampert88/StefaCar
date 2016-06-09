package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Outfitter;
import com.stefanini.stefacar.model.service.impl.OutfitterServiceImpl;

@ManagedBean
@SessionScoped
public class OutfitterManagedBean {

	private Outfitter outfitter;
	private List<Outfitter> dataList;

	@Inject
	protected OutfitterServiceImpl service;

	@PostConstruct
	public void init() {
		outfitter = new Outfitter();
		dataList = service.loadAllOutfitterFromDataBase();
	}

	public void save() {
		service.save(getOutfitter());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Fornecedor salvo com sucesso");
		clean();
	}

	public void delete(Outfitter outfitter) {
		service.delete(outfitter);
		dataList.remove(outfitter);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Fornecedor excluido com sucesso!");
	}

	public void setList(List<Outfitter> dataList) {
		this.dataList = dataList;
	}

	public List<Outfitter> getDataList() {
		return dataList;
	}

	public Outfitter getOutfitter() {
		return outfitter;
	}

	public void setOutfitter(Outfitter outfitter) {
		this.outfitter = outfitter;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("outfitterRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void clean() {
		setOutfitter(new Outfitter());
	}
}