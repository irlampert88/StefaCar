package com.stefanini.stefacar.model.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Servicing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "client_id")
	private Client client;		
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "model_id")
	private ModelCar model;	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@Temporal(TemporalType.DATE)
	@Column(name = "dataOfIssue")
	private Date dataOfIssue;
	@Temporal(TemporalType.DATE)
	@Column(name = "forecastDate")
	private Date forecastDate;
	@Column(name = "initialValue", precision = 10, scale = 2)
	private Double initialValue;
	@Column(name = "kindOfService")
	private String kindOfService;
	@Column(name = "comments")
	private String comments;
	
	
	public Servicing() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ModelCar getModel() {
		return model;
	}

	public void setModel(ModelCar model) {
		this.model = model;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Date getDataOfIssue() {
		return dataOfIssue;
	}

	public void setDataOfIssue(Date dataOfIssue) {
		this.dataOfIssue = dataOfIssue;
	}

	public Date getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(Date forecastDate) {
		this.forecastDate = forecastDate;
	}
	
	public Double getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(Double initialValue) {
		this.initialValue = initialValue;
	}

	public String getKindOfService() {
		return kindOfService;
	}

	public void setKindOfService(String kindOfService) {
		this.kindOfService = kindOfService;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Servicing [id=" + id + ", client=" + client + ", model=" + model + ", employee=" + employee
				+ ", dataOfIssue=" + dataOfIssue + ", forecastDate=" + forecastDate + ", initialValue=" + initialValue
				+ ", kindOfService=" + kindOfService + ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((dataOfIssue == null) ? 0 : dataOfIssue.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((forecastDate == null) ? 0 : forecastDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((initialValue == null) ? 0 : initialValue.hashCode());
		result = prime * result + ((kindOfService == null) ? 0 : kindOfService.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Servicing other = (Servicing) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (dataOfIssue == null) {
			if (other.dataOfIssue != null)
				return false;
		} else if (!dataOfIssue.equals(other.dataOfIssue))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (forecastDate == null) {
			if (other.forecastDate != null)
				return false;
		} else if (!forecastDate.equals(other.forecastDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initialValue == null) {
			if (other.initialValue != null)
				return false;
		} else if (!initialValue.equals(other.initialValue))
			return false;
		if (kindOfService == null) {
			if (other.kindOfService != null)
				return false;
		} else if (!kindOfService.equals(other.kindOfService))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
	
}