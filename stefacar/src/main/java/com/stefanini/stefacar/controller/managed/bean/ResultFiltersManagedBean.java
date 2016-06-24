package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.stefanini.stefacar.controller.converter.DateUtil;
import com.stefanini.stefacar.controller.shared.MessengerSystem;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.model.domain.ResultSearch;
import com.stefanini.stefacar.model.repository.impl.CashRegisterRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.SaleRepositoryImpl;

@ManagedBean
@ViewScoped
public class ResultFiltersManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	CashRegisterRepositoryImpl repositoryCash;

	@Inject
	SaleRepositoryImpl repositorySale;

	private List<ResultSearch> result;
	private List<ResultSearch> resultSalesMan;
	private Date specificDate;
	private Date interval1;
	private Date interval2;
	private String month, year;

	@PostConstruct
	public void init() {		
		result = new ArrayList<>();
		resultSalesMan = repositorySale.listForRanking();
	}
	//rever essa l�gica se precisa zerar as lista ou s� os atributos
//	private void clean(){
//		this.interval1 = null;
//		this.interval2 = null;
//		this.month = null;
//		this.specificDate = null;
//		this.year = null;
//	}

	public void upgradeRanking() {
		resultSalesMan = repositorySale.listForRanking();
	}
	
	public void upgradeRankingToDay() {
		if(specificDate != null){
			resultSalesMan = repositorySale.listForRankingOnDay(DateUtil.dateToStringFormatBD(specificDate));			
		}else{
			MessengerSystem.nootificaErro("Ops!", "Voc� n�o preencheu a Data.");
		}
		
	}
	
	public void upgradeRankingToMonth() {
		resultSalesMan = repositorySale.listForRanking();
	}
	
	public void upgradeRankingToInterval() {
		resultSalesMan = repositorySale.listForRanking();
	}
	
	public void populatesPerDay() {
		result = returnSearch(specificDate);
	}

	private List<ResultSearch> returnSearch(Date d) {
		if (specificDate != null) {
			result = repositoryCash.closingPerDay(DateUtil.dateToStringFormatBD(d));
//			clean();
		}
		return result;
	}	

	public void populatesPerPeriod() {
		result = returnSearch(interval1, interval2);
	}
	
	private List<ResultSearch> returnSearch(Date d1, Date d2) {
		if (interval1 != null && interval2 != null) {
			result = repositoryCash.closingPerPeriod(DateUtil.dateToStringFormatBD(d1),
					DateUtil.dateToStringFormatBD(d2));
		}
		return result;
	}	
	
	public void populatesPerMonth() {
		result = returnSearch(month, year);
	}

	private List<ResultSearch> returnSearch(String month, String year) {
		if (month != null && year != null) {
			result = repositoryCash.closingPerMonth(month, year);
		}
		return result;
	}	
	
	public void populatesPerYear() {
		result = returnSearchYear(year);
	}

	private List<ResultSearch> returnSearchYear(String year) {
		if (year != null) {
			result = repositoryCash.closingPerYear(year);
		}
		return result;
	}
	
	// COME�O DAS SELE��ES DE VENDEDORES
	
	public void populatesSellerOnDay() {
		resultSalesMan = returnSellerOnDay(specificDate);
	}
	
	private List<ResultSearch> returnSellerOnDay(Date d){
		if (specificDate != null) {
			resultSalesMan = repositorySale.listForRankingOnDay(DateUtil.dateToStringFormatBD(d));
		}
		return resultSalesMan;
	}
	
	public void populatesSellerOnMonth(){
		resultSalesMan = returnSellerOnMonth(month, year);		
	}
	
	private List<ResultSearch> returnSellerOnMonth(String month, String year){
		if (month != null && year != null) {
			resultSalesMan = repositorySale.listForRankingOnMonth(month, year);
		}
		return resultSalesMan;
	}
	
	public void populatesSellerOnPeriod(){
		resultSalesMan = returnSellerOnPeriod(interval1, interval2);	
	}
	
	private List<ResultSearch> returnSellerOnPeriod(Date d1, Date d2){
		if (interval1 != null && interval2 != null) {
			resultSalesMan = repositorySale.listForRankingOnPeriod(DateUtil.dateToStringFormatBD(d1),
					DateUtil.dateToStringFormatBD(d2));
		}
		return resultSalesMan;
	}
	
	// GETERS & SETERS

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

	public List<ResultSearch> getResultSalesMan() {
		return resultSalesMan;
	}

	public void setResultSalesMan(List<ResultSearch> resultList) {
		this.resultSalesMan = resultList;
	}
}
