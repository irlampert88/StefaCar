package com.stefanini.stefacar.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Stock implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable=false)
	private Integer quantity;
	@OneToOne
	@JoinColumn(name = "idCarro", nullable = false)
	@EmbeddedId
	private Car car;
	
	
	public Stock() {
		
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", stockCar=" + car + "]";
	}
}
