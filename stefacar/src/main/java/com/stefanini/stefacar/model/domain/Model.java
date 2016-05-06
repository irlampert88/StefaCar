package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Model {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idModel;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String combustivel;
	@Column(nullable=false)
	private Integer ano;
	@Column(nullable=false)
	private Double preco;
	@ManyToOne
	private Brand brand;
	
	public Model() {

	}

	public Integer getIdModelo() {
		return idModel;
	}

	public void setIdModelo(Integer idModelo) {
		this.idModel = idModelo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((idModel == null) ? 0 : idModel.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
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
		Model other = (Model) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (combustivel == null) {
			if (other.combustivel != null)
				return false;
		} else if (!combustivel.equals(other.combustivel))
			return false;
		if (idModel == null) {
			if (other.idModel != null)
				return false;
		} else if (!idModel.equals(other.idModel))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Model [idModel=" + idModel + ", nome=" + nome + ", combustivel=" + combustivel + ", ano=" + ano
				+ ", preco=" + preco + ", brand=" + brand + "]";
	}
	
	
	
}
