package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BrandCar {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBrandCar;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String nationality;

	
	public BrandCar() {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdBrandCar() {
		return idBrandCar;
	}


	public void setIdBrandCar(Integer idBrandCar) {
		this.idBrandCar = idBrandCar;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBrandCar == null) ? 0 : idBrandCar.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
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
		BrandCar other = (BrandCar) obj;
		if (idBrandCar == null) {
			if (other.idBrandCar != null)
				return false;
		} else if (!idBrandCar.equals(other.idBrandCar))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BrandCar [idBrandCar=" + idBrandCar + ", name=" + name + ", nationality=" + nationality + "]";
	}

	
	
}
