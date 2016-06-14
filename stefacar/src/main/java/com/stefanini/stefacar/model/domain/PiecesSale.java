package com.stefanini.stefacar.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PiecesSale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSale;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Client client;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Employee employee;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pieces_id", nullable = false)
	private List<Pieces> pieces;

	public Integer getIdSale() {
		return idSale;
	}

	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}

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

	public List<Pieces> getPieces() {
		return pieces;
	}

	public void setPieces(List<Pieces> pieces) {
		this.pieces = pieces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((idSale == null) ? 0 : idSale.hashCode());
		result = prime * result + ((pieces == null) ? 0 : pieces.hashCode());
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
		PiecesSale other = (PiecesSale) obj;
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
		if (pieces == null) {
			if (other.pieces != null)
				return false;
		} else if (!pieces.equals(other.pieces))
			return false;
		return true;
	}

}
