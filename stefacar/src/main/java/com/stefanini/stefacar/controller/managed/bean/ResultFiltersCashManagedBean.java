package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.stefanini.stefacar.controller.converter.DateUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;

@ManagedBean
@ViewScoped
public class ResultFiltersCashManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CashRegisterRepositoryImpl repositoryCash;
	
	private List<Object[]>resultList;
	private Date specificDate;
	private Date interval1;
	private Date interval2;
	private String month, year;
	
	
	@PostConstruct
	public void init() {
		resultList = new ArrayList<>();		
	}
	
	private List<Object[]> returnSearch(Date d){
		if (specificDate != null) {
			resultList = repositoryCash.closingPerDay(DateUtil.dateToStringFormatBD(d));
		}
		return resultList;			
	}
	
	private List<Object[]> returnSearch(Date d1, Date d2){
		if (interval1 != null && interval2 != null) {
			resultList = repositoryCash.closingPerPeriod(DateUtil.dateToStringFormatBD(d1), DateUtil.dateToStringFormatBD(d2));
		}
		return resultList;			
	}
	
	private List<Object[]> returnSearch(String month){
		if (month != null) {
			resultList = repositoryCash.closingPerMonth(month);
		}
		return resultList;			
	}
	
	private List<Object[]> returnSearchYear(String year){
		if (year != null) {
			resultList = repositoryCash.closingPerYear(year);
		}
		return resultList;			
	}
		
	public void populatesPerDay(){
		resultList = returnSearch(specificDate);
	}
	
	public void populatesPerPeriod(){
		resultList = returnSearch(interval1, interval2);
	}
	
	public void populatesPerMonth(){
		resultList = returnSearch(month);
	}
	
	public void populatesPerYear(){
		resultList = returnSearchYear(year);
	}
	//GETERS & SETERS

	public List<Object[]> getResultList() {
		return resultList;
	}

	public void setResultList(List<Object[]> resultList) {
		this.resultList = resultList;
	}

	public Date getSpecificDate() {
		return specificDate;
	}

	public void setSpecificDate(Date specificDate) {
		this.specificDate = specificDate;
	}

	public Date getInterval1() {
		return interval1;
	}

	public void setInterval1(Date interval1) {
		this.interval1 = interval1;
	}

	public Date getInterval2() {
		return interval2;
	}

	public void setInterval2(Date interval2) {
		this.interval2 = interval2;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}	
}
