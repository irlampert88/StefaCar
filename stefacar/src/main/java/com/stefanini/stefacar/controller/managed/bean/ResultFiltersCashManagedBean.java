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

import com.stefanini.stefacar.model.domain.ResultSearch;
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
		
	private List<ResultSearch> result;
	private Date specificDate;
	private Date interval1;
	private Date interval2;
	private String month, year;
	
	
	@PostConstruct
	public void init() {
		result = new ArrayList<>();		
	}
	
	private List<ResultSearch> returnSearch(Date d){
		if (specificDate != null) {
			result = repositoryCash.closingPerDay(DateUtil.dateToStringFormatBD(d));
		}
		return result;			
	}
	
	private List<ResultSearch> returnSearch(Date d1, Date d2){
		if (interval1 != null && interval2 != null) {
			result = repositoryCash.closingPerPeriod(DateUtil.dateToStringFormatBD(d1), DateUtil.dateToStringFormatBD(d2));
		}
		return result;			
	}
	
	private List<ResultSearch> returnSearch(String month, String year){
		if (month != null && year !=null) {
			result = repositoryCash.closingPerMonth(month, year);
		}
		return result;			
	}
	
	private List<ResultSearch> returnSearchYear(String year){
		if (year != null) {
			result = repositoryCash.closingPerYear(year);
		}
		return result;			
	}
		
	public void populatesPerDay(){
		result = returnSearch(specificDate);
	}
	
	public void populatesPerPeriod(){
		result = returnSearch(interval1, interval2);
	}
	
	public void populatesPerMonth(){
		result = returnSearch(month, year);
	}
	
	public void populatesPerYear(){
		result = returnSearchYear(year);
	}
	//GETERS & SETERS

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

	public List<ResultSearch> getResult() {
		return result;
	}

	public void setResult(List<ResultSearch> list) {
		this.result = list;
	}	
	
}
