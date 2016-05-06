package com.stefanini.stefacar.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Brand {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMarca;
	@Column(nullable=false)
	private String name;
	@OneToMany(cascade=CascadeType.REFRESH)	
	@JoinColumn(name="idModel")
	private List<Model> models;
	

}
