package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.service.impl.ClientServiceImpl;

@ManagedBean
@ViewScoped
public class ClientManagedBean {

	private Client client;
	private List<Client> dataList;

	@Inject
	protected ClientServiceImpl service;

	public ClientManagedBean(ClientServiceImpl service) {
		this.service = service;
	}

	public ClientManagedBean() {
	}

	public void save() {
		service.save(getClient());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de cliente salvo com sucesso");
		clean();

	}

	public void delete(Client client) {
		service.delete(client);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro de cliente excluido com sucesso!");
		clean();

	}

	private void listAllRecords() {
		setList(service.listAllRecords());
	}

	public void setList(List<Client> dataList) {
		this.dataList = dataList;
	}

	public List<Client> getDataList() {
		if (dataList == null) {
			listAllRecords();
		}
		return dataList;
	}

	public Client getClient() {
		if (client == null) {
			clean();
		}
		return client;
	}

	public void setEntity(Client entity) {
		this.client = entity;
	}

	public void clean() {
		setEntity(new Client());
	}
}