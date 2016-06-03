package com.stefanini.stefacar.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity 
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idCliente", nullable = false)
	private Client client;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idFuncionario", nullable = false)
	private Employee employee;
<<<<<<< HEAD
	@OneToOne
	@JoinColumn(name = "idStock", nullable = false)
=======
	@OneToOne(cascade = CascadeType.REFRESH)
<<<<<<< HEAD
	@JoinColumn(name = "idCarro", nullable = false)
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	private Stock stock;
=======
	@JoinColumn(name = "Carro", nullable = false)
	private Car car;
	@Column
	private boolean status;//true = venda ativa & false = venda finalizada
	
	public Sale() {
		this.client = new Client();
		this.car = new Car();
		this.employee = new Employee();
		this.status = true;
	}
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
	
	
	//GETERS & SETERS
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
<<<<<<< HEAD
<<<<<<< HEAD
	public Integer getIdSale() {
		return idSale;
=======
	public Stock getStock() {
		return stock;
=======
	public Car getCar() {
		return car;
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Integer getId() {
		return id;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
	}
	public void setId(Integer idSale) {
		this.id = idSale;
	}	
	public boolean isStatus() {
		return status;
	}
<<<<<<< HEAD
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
=======
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getStatusString(){
		if(isStatus())
			return "Venda Ativa";
		else 
			return "Venda Finalizada";
	}

	//HASH & EQUALS
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
<<<<<<< HEAD
<<<<<<< HEAD
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((idSale == null) ? 0 : idSale.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
=======
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
=======
		result = prime * result + ((car == null) ? 0 : car.hashCode());
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
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
		Sale other = (Sale) obj;
<<<<<<< HEAD
<<<<<<< HEAD
=======
		if (stock == null) {
			if (other.stock != null)
=======
		if (car == null) {
			if (other.car != null)
>>>>>>> a2dbf77445d707f8bb240f1d3f8a7a08972e860a
				return false;
		} else if (!car.equals(other.car))
			return false;
>>>>>>> fc9b014bcef8652d2d8fb2ecf43d22430590a44e
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sale [idSale=" + idSale + ", client=" + client + ", employee=" + employee + ", stock=" + stock + "]";
	}
	
}
