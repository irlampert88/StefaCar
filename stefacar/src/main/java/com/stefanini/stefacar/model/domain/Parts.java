package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParts;

	@Column(nullable = false)
	private String partsName;

	@Column(nullable = false)
	private Integer partsId;

	@Column(nullable = false)
	private Double partsValue;

	@Column(nullable = false)
	private Integer partsStash;

//falta implementar um Fornecedor
	public int getIdParts() {
		return idParts;
	}

	public void setIdParts(int idParts) {
		this.idParts = idParts;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public Integer getPartsId() {
		return partsId;
	}

	public void setPartsId(Integer partsId) {
		this.partsId = partsId;
	}

	public Double getPartsValue() {
		return partsValue;
	}

	public void setPartsValue(Double partsDouble) {
		this.partsValue = partsDouble;
	}

	public Integer getPartsStash() {
		return partsStash;
	}

	public void setPartsStash(Integer partsStash) {
		this.partsStash = partsStash;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idParts;
		result = prime * result + ((partsValue == null) ? 0 : partsValue.hashCode());
		result = prime * result + ((partsId == null) ? 0 : partsId.hashCode());
		result = prime * result + ((partsName == null) ? 0 : partsName.hashCode());
		result = prime * result + ((partsStash == null) ? 0 : partsStash.hashCode());
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
		Parts other = (Parts) obj;
		if (idParts != other.idParts)
			return false;
		if (partsValue == null) {
			if (other.partsValue != null)
				return false;
		} else if (!partsValue.equals(other.partsValue))
			return false;
		if (partsId == null) {
			if (other.partsId != null)
				return false;
		} else if (!partsId.equals(other.partsId))
			return false;
		if (partsName == null) {
			if (other.partsName != null)
				return false;
		} else if (!partsName.equals(other.partsName))
			return false;
		if (partsStash == null) {
			if (other.partsStash != null)
				return false;
		} else if (!partsStash.equals(other.partsStash))
			return false;
		return true;
	}

}
