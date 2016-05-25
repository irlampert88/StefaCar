package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Stock {
	
	
	@Column(nullable=false)
	private Integer qunatity;
	@OneToOne
	@JoinColumn(name = "idCarro", nullable = false)
	private Car car;
	
	public Stock() {
		
	}
	
	public Integer getQunatity() {
		return qunatity;
	}
	public void setQunatity(Integer qunatity) {
		this.qunatity = qunatity;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Stock [qunatity=" + qunatity + ", stockCar=" + car + "]";
	}

	
	
	

}
