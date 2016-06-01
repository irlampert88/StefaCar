package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Client;

import com.stefanini.stefacar.model.service.impl.ClientServiceImpl;

@ManagedBean
@ViewScoped
public class ClientManagedBean {

	private Client client;
	private List<Client> dataList;

	@Inject
	protected ClientServiceImpl service;

	@PostConstruct
	public void init() {
		client = new Client();
		dataList = service.loadAllClientFromDataBase();
	}

	public void save() {
		service.save(getClient());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Cliente salvo com sucesso");
		clean();
	}

	public void delete(Client client) {
		service.delete(client);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de Cliente excluido com sucesso!");
	}

	public void setList(List<Client> dataList) {
		this.dataList = dataList;
	}

	public List<Client> getDataList() {
		return dataList;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void clean() {
		setClient(new Client());
	}
}