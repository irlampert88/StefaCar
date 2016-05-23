package com.stefanini.stefacar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Piece {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, unique=true)
	private Integer serialNumber;
	
	@Column
	private ModelCar model;
	
	@Column(nullable=false)
	private Outfitter outfitter;
	
	@Column(nullable=false)
	private Manufacturer manufacterer;
	
	@Column(nullable=false, unique=true)
	private String email;
	
}

