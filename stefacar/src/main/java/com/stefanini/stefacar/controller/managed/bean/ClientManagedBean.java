package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.service.impl.ClientServiceImpl;

@ManagedBean
@ViewScoped
public class ClientManagedBean {

	private Client client;
	private List<Client> listOfClients;
	@Inject
	private ClientServiceImpl service;

	public ClientManagedBean() {
	}

	public void save() {
		service.saveClientOnDB(getClient());
		loadClientList();

	}

	public void delete(Client client) {
		service.deleteClient(client);
		loadClientList();
	}

	private void limpar() {
		setClient(new Client());

	}

	public Client getClient() {
		if (client == null) {
			limpar();
		}
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListOfClients() {
		return listOfClients;
	}

	public void setListOfClients(List<Client> listOfClients) {
		this.listOfClients = listOfClients;
	}

	public void loadClientList() {
		setListOfClients(service.loadAllClientsFromDB());
	}

}
