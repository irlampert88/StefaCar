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
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login")
	private Integer id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = true)
	private Boolean ROLE_ADM;
	@Column(nullable = true)
	private Boolean ROLE_SALESMAN;
	@Column(nullable = true)
	private Boolean ROLE_MANAGER;
	@Column(nullable = true)
	private Boolean ROLE_MECHANIC;
	@Column(nullable = true)
	private Boolean login;
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id")
	private Employee employee;

	public Login() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getROLE_ADM() {
		return ROLE_ADM;
	}

	public void setROLE_ADM(Boolean rOLE_ADM) {
		ROLE_ADM = rOLE_ADM;
	}

	public Boolean getROLE_SALESMAN() {
		return ROLE_SALESMAN;
	}

	public void setROLE_SALESMAN(Boolean rOLE_SALESMAN) {
		ROLE_SALESMAN = rOLE_SALESMAN;
	}

	public Boolean getROLE_MANAGER() {
		return ROLE_MANAGER;
	}

	public void setROLE_MANAGER(Boolean rOLE_MANAGER) {
		ROLE_MANAGER = rOLE_MANAGER;
	}

	public Boolean getROLE_MECHANIC() {
		return ROLE_MECHANIC;
	}

	public void setROLE_MECHANIC(Boolean rOLE_MECHANIC) {
		ROLE_MECHANIC = rOLE_MECHANIC;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ROLE_ADM == null) ? 0 : ROLE_ADM.hashCode());
		result = prime * result + ((ROLE_MANAGER == null) ? 0 : ROLE_MANAGER.hashCode());
		result = prime * result + ((ROLE_MECHANIC == null) ? 0 : ROLE_MECHANIC.hashCode());
		result = prime * result + ((ROLE_SALESMAN == null) ? 0 : ROLE_SALESMAN.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Login other = (Login) obj;
		if (ROLE_ADM == null) {
			if (other.ROLE_ADM != null)
				return false;
		} else if (!ROLE_ADM.equals(other.ROLE_ADM))
			return false;
		if (ROLE_MANAGER == null) {
			if (other.ROLE_MANAGER != null)
				return false;
		} else if (!ROLE_MANAGER.equals(other.ROLE_MANAGER))
			return false;
		if (ROLE_MECHANIC == null) {
			if (other.ROLE_MECHANIC != null)
				return false;
		} else if (!ROLE_MECHANIC.equals(other.ROLE_MECHANIC))
			return false;
		if (ROLE_SALESMAN == null) {
			if (other.ROLE_SALESMAN != null)
				return false;
		} else if (!ROLE_SALESMAN.equals(other.ROLE_SALESMAN))
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}