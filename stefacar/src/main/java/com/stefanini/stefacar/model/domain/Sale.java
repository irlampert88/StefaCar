package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSale;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCliente", nullable = false)
	private Client client;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idFuncionário", nullable = false)
	private Employee employee;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCarro", nullable = false)
	private Car car;
	
	
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
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	//Criar o HashCode e equals não pude criar antes pq não existe o equals nos objetos relacionados.	
}
