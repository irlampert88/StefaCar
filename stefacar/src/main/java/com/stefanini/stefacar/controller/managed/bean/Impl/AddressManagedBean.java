package com.stefanini.stefacar.controller.managed.bean.Impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.stefanini.stefacar.model.domain.Address;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;
import com.stefanini.stefacar.model.service.impl.AddressService;
import com.stefanini.stefacar.util.Mensageiro;

@ManagedBean
@ViewScoped
public class AddressManagedBean extends AbstractManagedBeanImplementation<Address>{

	protected AbstractServiceImplementation<Address> service;
	private List<Address> dataList;
	
	public AddressManagedBean(AddressService service) {
		this.service = service;
	}
	
	public AddressManagedBean(){
		
	}
	
	public void save() {
		Mensageiro.notificaInformacao("Parabéns!", "Endereço salvo com sucesso!");
	}
	
	public void delete(Address address) {
		service.delete(address);
		Mensageiro.notificaInformacao("Parabéns!", "Endereço deletado com sucesso!");
	}
	
	private void listAllRecordsFromDataBase() {
		setListaDeDados(service.listAllRecordsFromDataBase());
	}
	
	public void setListaDeDados(List<Address> dataList) {
		this.dataList = dataList;
	}
	
	public List<Address> getDataList() {
		if (dataList == null) {
			listAllRecordsFromDataBase();
		}
		return dataList;
	}
	
}
