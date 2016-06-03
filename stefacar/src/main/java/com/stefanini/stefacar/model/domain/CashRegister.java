package com.stefanini.stefacar.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.stefanini.stefacar.controller.converter.LocalDateAttributeConverter;
import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;

@Entity
public class CashRegister {
	
	@Id
	@Convert(converter = LocalDateAttributeConverter.class)
	private LocalDate dateOfSale;
	@Column
	private Double amount;
	@Column
	private Double amountPaid;
	@Column
	private Double transshipment;	
	@Enumerated
	private TypeOfPayment typePayment;
	@OneToMany(cascade = CascadeType.REFRESH)
	@Column(name = "Data Pagamento", nullable = true)
	private List<Sale> sales;
	
	public CashRegister() {
		sales = new ArrayList<>();
		dateOfSale = LocalDate.now();
	}
	
	//GETERS & SETERS
	
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

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sale) {
		this.sales = sale;
	}
}
