package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCar")
	private Integer id;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idModel")
	private ModelCar model;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private String color;
	@Column(nullable = false)
	private boolean avaliable;

	public Car() {
	}
	
	public Car(ModelCar carModel, Double price, String color, Integer id){
		this.model = carModel;
		this.price = price;
		this.color = color;
		this.id = id;
		this.avaliable = false;
	}
	
	//GETERS & SETERS
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ModelCar getModel() {
		return model;
	}

	public String getCarStatusString() {
		if (this.avaliable) {
			return "Disponivel";
		} else
			return "Vendido";
	}

	public void setModel(ModelCar model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isAvaliable() {
		return avaliable;
	}

	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	
	public String getAvaliableString(){
		if(this.avaliable){
			return "Disponivel";
		}else{
			return "Vendido";
		}
	}
	
	public void changeAvailability(){
		if(this.avaliable)
			this.avaliable = false;
		else 
			this.avaliable = true;
	}
	
	//HASH & EQUALS

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (avaliable ? 1231 : 1237);
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
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (avaliable != other.avaliable)
			return false;
		return true;
	}

}
