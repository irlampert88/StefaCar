package com.stefanini.stefacar.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ServiceModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable=false)
	private String typeService;
	
	
	@Column(nullable=false)
	private LocalDate serviceDate;
	
	@Column(nullable=false)
	private double prize;
	
	public ServiceModel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeService() {
		return typeService;
	}

	public void setTypeService(String typeService) {
		this.typeService = typeService;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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