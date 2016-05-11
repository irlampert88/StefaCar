package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.jsf.MessengerSystem;
import com.stefanini.stefacar.model.domain.Address;
import com.stefanini.stefacar.model.service.impl.AbstractServiceImplementation;
import com.stefanini.stefacar.model.service.impl.AddressService;

@ManagedBean
@ViewScoped
public class AddressManagedBean extends AbstractManagedBeanImplementation<Address> {

	private Address address;
	
	@Inject
	protected AbstractServiceImplementation<Address> service;
	private List<Address> dataList;

	public AddressManagedBean(AddressService service) {
		this.service = service;
	}

	public AddressManagedBean() {

	}

	public void save() {
		service.save(getAddress());
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully saved !");
	}

	public void delete(Address address) {
		service.delete(address);
		MessengerSystem.notificaInformacao("Congratulations! " , " Loan successfully deleted !");
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

	public Address getAddress() {
		if (address == null) {
			clean();
		}
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void clean() {
		setAddress(new Address());
	}
}
