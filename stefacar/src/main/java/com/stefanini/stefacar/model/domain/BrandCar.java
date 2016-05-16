package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BrandCar {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBrandCar;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String nationality;
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="idModelCar")
	private ModelCar modelCarList;

	
	public BrandCar() {}

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

	public ModelCar getModelCarList() {
		return modelCarList;
	}

	public void setModelCarList(ModelCar modelCarList) {
		this.modelCarList = modelCarList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBrandCar == null) ? 0 : idBrandCar.hashCode());
		result = prime * result + ((modelCarList == null) ? 0 : modelCarList.hashCode());
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
		if (modelCarList == null) {
			if (other.modelCarList != null)
				return false;
		} else if (!modelCarList.equals(other.modelCarList))
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
		return "BrandCar [idBrandCar=" + idBrandCar + ", name=" + name + ", nationality=" + nationality
				+ ", modelCarList=" + modelCarList + "]";
	}
	
	
}
