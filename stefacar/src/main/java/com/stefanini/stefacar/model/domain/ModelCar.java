package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ModelCar {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idModelCar;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String version;

	@Column(nullable=false)
	private String year;

	@Column(nullable=false)
	private String displacement;
	
//	@Column(nullable=false)
//	private BrandCar brandCar;
//
//	public BrandCar getBrandCar() {
//		return brandCar;
//	}
//
//	public void setBrandCar(BrandCar brandCar) {
//		this.brandCar = brandCar;
//	}


	public ModelCar() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdModelCar() {
		return idModelCar;
	}

	public void setIdModelCar(Integer idModelCar) {
		this.idModelCar = idModelCar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((brandCar == null) ? 0 : brandCar.hashCode());
		result = prime * result + ((displacement == null) ? 0 : displacement.hashCode());
		result = prime * result + ((idModelCar == null) ? 0 : idModelCar.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		ModelCar other = (ModelCar) obj;
//		if (brandCar == null) {
//			if (other.brandCar != null)
//				return false;
//		} else if (!brandCar.equals(other.brandCar))
//			return false;
		if (displacement == null) {
			if (other.displacement != null)
				return false;
		} else if (!displacement.equals(other.displacement))
			return false;
		if (idModelCar == null) {
			if (other.idModelCar != null)
				return false;
		} else if (!idModelCar.equals(other.idModelCar))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "ModelCar [idModelCar=" + idModelCar + ", name=" + name + ", version=" + version + ", year=" + year
				+ ", displacement=" + displacement + "]";
	}

	
}
