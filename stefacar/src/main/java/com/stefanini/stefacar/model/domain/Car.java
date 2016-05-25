package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.stefanini.stefacar.model.domain.ModelCar;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCar")
	private Integer id;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCarModel")
	private ModelCar carModel;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private String carColor;
	@Column(nullable = false)
	private boolean avaliable;

	public Car() {
	}
	
	public Car(ModelCar carModel, Double price, String color, Integer id){
		this.carModel = carModel;
		this.price = price;
		this.carColor = color;
		this.id = id;
		this.avaliable = false;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ModelCar getCarModel() {
		return carModel;
	}

	public String getCarStatusString() {
		if (this.avaliable) {
			return "Disponivel";
		} else
			return "Vendido";
	}

	public void setCarModel(ModelCar carModel) {
		this.carModel = carModel;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
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
		if (carColor == null) {
			if (other.carColor != null)
				return false;
		} else if (!carColor.equals(other.carColor))
			return false;
		if (carModel == null) {
			if (other.carModel != null)
				return false;
		} else if (!carModel.equals(other.carModel))
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
