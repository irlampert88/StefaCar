package com.stefanini.stefacar.model.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ServiceModel implements Serializable{
	
	@Column(nullable=false)
	private String typeService;//criar uma Enum para alimentar esse atributo.
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(nullable = false)
	private AbstractPerson client;
	@Column(nullable=false)
	private LocalDate serviceDate;
	@Column(nullable=false)
	private double prize;//criar uma forma de auto incrementar os valores conforme o serviço ou com Enum etc.
	public String getTypeService() {
		return typeService;
	}
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}
	public AbstractPerson getClient() {
		return client;
	}
	public void setClient(AbstractPerson client) {
		this.client = client;
	}
	public LocalDate getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((serviceDate == null) ? 0 : serviceDate.hashCode());
		result = prime * result + ((typeService == null) ? 0 : typeService.hashCode());
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
		ServiceModel other = (ServiceModel) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (Double.doubleToLongBits(prize) != Double.doubleToLongBits(other.prize))
			return false;
		if (serviceDate == null) {
			if (other.serviceDate != null)
				return false;
		} else if (!serviceDate.equals(other.serviceDate))
			return false;
		if (typeService == null) {
			if (other.typeService != null)
				return false;
		} else if (!typeService.equals(other.typeService))
			return false;
		return true;
	}
}
