package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.stefanini.stefacar.controller.warehouse.TypeOfPayment;
import com.stefanini.stefacar.model.domain.CashRegisterPieces;
import com.stefanini.stefacar.model.domain.PiecesSale;
import com.stefanini.stefacar.model.repository.impl.CashRegisterPiecesRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.PiecesSaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.CashRegisterPiecesServiceImpl;

@ManagedBean
@ViewScoped
public class CashRegisterPiecesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Double totalValue;

	@Inject
	CashRegisterPiecesRepositoryImpl repositoryCash;

	@Inject
	PiecesSaleRepositoryImpl repositorySale;

	@Inject
	CashRegisterPiecesServiceImpl service;

	private CashRegisterPieces cashRegister;
	private List<PiecesSale> saleList;
	private double discountedOrInterest;

	@PostConstruct
	public void init() {
		cashRegister = new CashRegisterPieces();
		saleList = repositorySale.listAllRecordsByActive();
	}

	public void shutdown() {
		service.finalizesCashRegister(saleList);
		RequestContext.getCurrentInstance().execute("location.reload()");
	}

	public void closeSales() {
		cashRegister.getSale().setProgress(false);
		service.closeSale(cashRegister.getSale());
		cashRegister.setValue(discountedOrInterest);
		service.save(cashRegister);
		RequestContext.getCurrentInstance().execute("location.reload()");
	}

	public void calculatesDiscount(ValueChangeEvent event) {
		TypeOfPayment payment = (TypeOfPayment) event.getNewValue();
		this.cashRegister.setTypePayment(payment);
		discountedOrInterest = cashRegister.getTypePayment().calculateFinalValue(getTotalValue());
	}

	public TypeOfPayment[] getTypeOfPayMent() {
		return TypeOfPayment.values();
	}

	public Double calculateTotalValuePieces() {
		for (PiecesSale piecesSale : saleList) {
			int coun = 0;
			totalValue = piecesSale.getPieces().get(coun).getValue();
			coun++;
		}
		return totalValue;
	}

	public void calculatesTransshipment() {
		cashRegister.setChange(cashRegister.getAmountPaid() - discountedOrInterest);
	}

	public void upgradeSales() {
		saleList = repositorySale.listAllRecordsByActive();
	}

	public void selectedSale(PiecesSale piecesSale) {
		cashRegister.setSale(piecesSale);
		RequestContext.getCurrentInstance().execute("PF('dialogCloseSalesPieces').show()");
	}

	public CashRegisterPieces getCashRegister() {
		return cashRegister;
	}

	public void setCashRegister(CashRegisterPieces cashRegister) {
		this.cashRegister = cashRegister;
	}

	public double getDiscountedOrInterest() {
		return discountedOrInterest;
	}

	public void setDiscountedOrInterest(double discountedOrInterest) {
		this.discountedOrInterest = discountedOrInterest;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<PiecesSale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<PiecesSale> saleList) {
		this.saleList = saleList;
	}

}
