package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Provider;
import com.stefanini.stefacar.model.service.impl.ProviderService;

@ManagedBean
@ViewScoped
public class ProviderManagedBean extends AbstractManagedBeanImplementation<Provider> {

	private Provider provider;
	@Inject
	protected ProviderService service;
	private List<Provider> dataList;

	public ProviderManagedBean(ProviderService service) {
		this.service = service;
	}

	public ProviderManagedBean() {

	}

	@Override
	public void save() {
		service.save(getProvider());
		MessengerSystem.notificaInformacao("Parabens!", "Um novo fornecedor foi salvo com sucesso");

	}

	@Override
	public void delete(Provider provider) {
		service.delete(provider);
		MessengerSystem.notificaInformacao("Parabens!", "Um novo fornecedor foi deletado com sucesso");
	}

	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}

	public void setListaDeDados(List<Provider> provider) {
		this.dataList = provider;
	}

	public List<Provider> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}

	public Provider getProvider() {
		if (provider == null) {
			clean();
		}
		return provider;
	}

	public void setEntity(Provider provider) {
		this.provider = provider;
	}

	public void clean() {
		setEntity(new Provider());
	}

}
