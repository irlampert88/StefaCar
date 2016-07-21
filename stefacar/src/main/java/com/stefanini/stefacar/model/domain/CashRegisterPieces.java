package com.stefanini.stefacar.model.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.stefanini.stefacar.controller.converter.LocalDateAttributeConverter;
import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;

@Entity
public class CashRegisterPieces {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cash_register")
	private Integer id;
	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(nullable = false)
	private LocalDate dateOfSale;
	@Column(nullable = false)
	private Double value;
	@Column(nullable = false)
	private Double amountPaid;
	@Column(nullable = false)
	private Double change;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "pieces_sale_id", nullable = false)
	private PiecesSale sale;
	@Enumerated(EnumType.STRING)
	private TypeOfPayment typePayment;

	public CashRegisterPieces() {
		sale = new PiecesSale();
		dateOfSale = LocalDate.now();
	}

	// GETERS & SETERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(LocalDate dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	public PiecesSale getSale() {
		return sale;
	}

	public void setSale(PiecesSale sale) {
		this.sale = sale;
	}

	public TypeOfPayment getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(TypeOfPayment typePayment) {
		this.typePayment = typePayment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((change == null) ? 0 : change.hashCode());
		result = prime * result + ((dateOfSale == null) ? 0 : dateOfSale.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((typePayment == null) ? 0 : typePayment.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		CashRegisterPieces other = (CashRegisterPieces) obj;
		if (amountPaid == null) {
			if (other.amountPaid != null)
				return false;
		} else if (!amountPaid.equals(other.amountPaid))
			return false;
		if (change == null) {
			if (other.change != null)
				return false;
		} else if (!change.equals(other.change))
			return false;
		if (dateOfSale == null) {
			if (other.dateOfSale != null)
				return false;
		} else if (!dateOfSale.equals(other.dateOfSale))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		if (typePayment != other.typePayment)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}