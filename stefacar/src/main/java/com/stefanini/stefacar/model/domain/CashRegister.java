package com.stefanini.stefacar.model.domain;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.stefanini.stefacar.controller.converter.LocalDateAttributeConverter;
import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;

@Entity
public class CashRegister {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Convert(converter = LocalDateAttributeConverter.class)
	@Column(nullable = false)
	private LocalDate dateOfSale;
	@Column(nullable = false)
	private Double amount;
	@Column(nullable = false)
	private Double amountPaid;
	@Column(nullable = false)
	private Double transshipment;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "sale_id", nullable = false)
	private Sale sale;	
	@Enumerated
	private TypeOfPayment typePayment;//ver com o Ivan para passar o id para o banco ou como persistir todas as enum's no banco
	
	public CashRegister() {
		sale = new Sale();
		dateOfSale = LocalDate.now();
	}	
	//GETERS & SETERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getTransshipment() {
		return transshipment;
	}

	public void setTransshipment(Double transshipment) {
		this.transshipment = transshipment;
	}

	public LocalDate getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(LocalDate dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

	public TypeOfPayment getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(TypeOfPayment typePayment) {
		this.typePayment = typePayment;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	//HASH & EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((dateOfSale == null) ? 0 : dateOfSale.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((transshipment == null) ? 0 : transshipment.hashCode());
		result = prime * result + ((typePayment == null) ? 0 : typePayment.hashCode());
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
		CashRegister other = (CashRegister) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (amountPaid == null) {
			if (other.amountPaid != null)
				return false;
		} else if (!amountPaid.equals(other.amountPaid))
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
		if (transshipment == null) {
			if (other.transshipment != null)
				return false;
		} else if (!transshipment.equals(other.transshipment))
			return false;
		if (typePayment != other.typePayment)
			return false;
		return true;
	}
}
