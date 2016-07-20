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
	private Date specificDateFinal;
	private String month, year;

	@PostConstruct
	public void init() {
		result = new ArrayList<>();
		resultSalesMan = repositorySale.listForRanking();
	}

	private void clean() {
		this.month = null;
		this.year = null;
		this.specificDate = null;
		this.specificDateFinal = null;
	}
	
	public void populates() {
		try {
			if (specificDate != null && specificDateFinal == null) {
				populatesPerDay();
				MessengerSystem.notifyInfo("Sucesso", "Relat�rio Di�rio");
			} else if (specificDate != null && specificDateFinal != null && month == null && year == null) {
				populatesPerPeriod();
				MessengerSystem.notifyInfo("Sucesso", "Relat�rio de Per�odo");
			} else if (month == null && year != null) {
				populatesPerYear();
				MessengerSystem.notifyInfo("Sucesso", "Relat�rio Anual");
			} else if (month != null && year != null){
				populatesPerMonth();
				MessengerSystem.notifyInfo("Sucesso", "Relat�rio Mensal");
			} else if(month != null && year == null){
				populatesPerMonth();
				MessengerSystem.notifyInfo("Foi gerado do ano corrente", "Relat�rio Mensal");
			} else {
				MessengerSystem.notifyError("Campo nulo", "Data Inicial n�o preenchida");
			}
		} catch (NullPointerException e) {
			MessengerSystem.notifyError("Campo nulo", "Data Inicial ou Ano n�o preenchida");
		} catch (IndexOutOfBoundsException e) {
			MessengerSystem.notifyError("Lista Vazia", "Lista Vazia");
		}
	}	

	public void populatesPerDay() {		
		result = returnSearch(specificDate);
		clean();
	}

	private List<ResultSearch> returnSearch(Date d) {
			result = repositoryCash.closingPerDay(DateUtil.dateToStringFormatBD(d));			
		return result;
	}

	public void populatesPerPeriod() {
		result = returnSearch(specificDate, specificDateFinal);
		clean();
	}

	private List<ResultSearch> returnSearch(Date d1, Date d2) {
		result = repositoryCash.closingPerPeriod(DateUtil.dateToStringFormatBD(d1), DateUtil.dateToStringFormatBD(d2));
		return result;
	}

	public void populatesPerMonth() {
		if(year == null){
			String yearTemporary = DateUtil.dateToStringYear(new Date());
			result = returnSearch(month, yearTemporary);
		}else{
			result = returnSearch(month, year);			
		}
		clean();
	}

	private List<ResultSearch> returnSearch(String month, String year) {
			result = repositoryCash.closingPerMonth(month, year);
		return result;
	}

	public void populatesPerYear() {
		result = returnSearchYear(year);
		clean();
	}

	private List<ResultSearch> returnSearchYear(String year) {
		if (year != null) {
			result = repositoryCash.closingPerYear(year);
		}
		return result;
	}


	// COME�O DAS SELE��ES DE VENDEDORES
	
	public void populatesSeller(){
		if (specificDate != null && specificDateFinal == null) {
			populatesSellerOnDay();
			MessengerSystem.notifyInfo("Sucesso", "Ranking Di�rio");
		} else if (specificDate != null && specificDateFinal != null && month == null && year == null) {
			populatesSellerOnPeriod();
			MessengerSystem.notifyInfo("Sucesso", "Ranking do Per�odo");
		} else if (month == null && year != null) {
			populatesPerYear();
			MessengerSystem.notifyInfo("Sucesso", "Relat�rio Anual");
		} else if (month != null && year != null){
			populatesSellerOnMonth();
			MessengerSystem.notifyInfo("Sucesso", "Relat�rio Mensal");
		} else if(month != null && year == null){
			populatesSellerOnMonth();
			MessengerSystem.notifyInfo("Foi gerado do ano corrente", "Relat�rio Mensal");
		} else {
			MessengerSystem.notifyError("Campo nulo", "Data Inicial n�o preenchida");
		}
	}

	public void populatesSellerOnDay() {
		resultSalesMan = returnSellerOnDay(specificDate);
		clean();
	}

	private List<ResultSearch> returnSellerOnDay(Date d) {
		resultSalesMan = repositorySale.listForRankingOnDay(DateUtil.dateToStringFormatBD(d));
		return resultSalesMan;
	}

	public void populatesSellerOnMonth() {
		if(year == null){
			String yearTemporary = DateUtil.dateToStringYear(new Date());
			resultSalesMan = returnSellerOnMonth(month, yearTemporary);			
		} else{
			resultSalesMan = returnSellerOnMonth(month, year);
		}
		clean();
	}

	private List<ResultSearch> returnSellerOnMonth(String month, String year) {
		resultSalesMan = repositorySale.listForRankingOnMonth(month, year);
		return resultSalesMan;
	}

	public void populatesSellerOnPeriod() {
		resultSalesMan = returnSellerOnPeriod(specificDate, specificDateFinal);
		clean();
	}

	private List<ResultSearch> returnSellerOnPeriod(Date d1, Date d2) {
		resultSalesMan=repositorySale.listForRankingOnPeriod(DateUtil.dateToStringFormatBD(d1), DateUtil.dateToStringFormatBD(d2));
		return resultSalesMan;
	}
	
	public void populatesSellerOnYear() {
		returnSellerOnYear(year);
		clean();
	}
	
	private List<ResultSearch> returnSellerOnYear(String year){
		return repositorySale.listForRankingOnYear(year);
	}

	// GETERS & SETERS

	public Date getSpecificDate() {
		return specificDate;
	}

	public void setSpecificDate(Date specificDate) {
		this.specificDate = specificDate;
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

	public Date getSpecificDateFinal() {
		return specificDateFinal;
	}

	public void setSpecificDateFinal(Date specificDateFinal) {
		this.specificDateFinal = specificDateFinal;
	}
}
