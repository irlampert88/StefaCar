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
	@Column(name="idCar")
	private Integer id;
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="idCarModel")
	private ModelCar carModel;
	@Column(nullable=false)
	private Double price;
	@Column(nullable=false)
	private String carColor;
	
	public Car() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ModelCar getCarModel() {
		return carModel;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
		result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carModel=" + carModel + ", price=" + price + ", carColor=" + carColor + "]";
	}
}
