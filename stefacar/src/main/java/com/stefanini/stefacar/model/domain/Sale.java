package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSale;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCliente", nullable = false)
	private Client client;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idFuncionario", nullable = false)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCarro", nullable = false)
	private Car car;
	
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Integer getIdSale() {
		return idSale;
	}
	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((idSale == null) ? 0 : idSale.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (idSale == null) {
			if (other.idSale != null)
				return false;
		} else if (!idSale.equals(other.idSale))
			return false;
		return true;
	}	
}
