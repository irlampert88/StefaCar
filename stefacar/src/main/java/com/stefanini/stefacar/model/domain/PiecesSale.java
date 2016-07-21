package com.stefanini.stefacar.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "id_pieces_sale")
	private Integer id;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Client client;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "funcionario_id", nullable = false)
	private Employee employee;

	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pieces_id", nullable = false)
	private List<Pieces> pieces;

	@Column(name = "progress", nullable = false)
	private boolean progress=true;

	 public PiecesSale() {
	 this.client = new Client();
	 this.employee = new Employee();
	 this.pieces = (List<Pieces>) new Pieces();
	 this.progress = true;
	 }

	public String getProgressString() {
		if (isProgress())
			return "Venda Ativa";
		else
			return "Venda Finalizada";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean isProgress() {
		return progress;
	}

	public void setProgress(boolean progress) {
		this.progress = progress;
	}

}
