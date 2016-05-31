package com.stefanini.stefacar.model.domain;

public class SaleCarShow {
	private Integer idModel, idCar;//Preciso para montar o Carro
	private double price;
	private String color, type, model, version, year;
	
	public SaleCarShow(double price, String type, String color, String model, String version, String year, Integer idModel, Integer idCar) {
		this.price = price;
		this.color = color;
		this.type = type;
		this.model = model;
		this.version = version;
		this.year = year;
		this.idModel = idModel;
		this.idCar = idCar;
	}
	
	public SaleCarShow() {
		
	}
	
	//GETERS & SETERS

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getIdModel() {
		return idModel;
	}

	public void setIdModel(Integer idModel) {
		this.idModel = idModel;
	}

	public Integer getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}	
}
