package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.PiecesSale;
import com.stefanini.stefacar.model.repository.impl.PiecesSaleRepositoryImpl;
import com.stefanini.stefacar.model.service.impl.PiecesSaleServiceImpl;

@ManagedBean
@ViewScoped
public class PiecesSaleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private PiecesSaleServiceImpl service;

	@Inject
	private PiecesSaleRepositoryImpl repositorySale;

	private PiecesSale piecesSale;
	private List<PiecesSale> listOfPiecesSales;

	@PostConstruct
	public void init() {
		piecesSale = new PiecesSale();
		listOfPiecesSales = repositorySale.listAllRecords();
	}

	public void save() {
		service.save(piecesSale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de peça salvo com sucesso");
		clean();
	}

	public void delete(PiecesSale piecesSale) {
		service.delete(piecesSale);
		listOfPiecesSales.remove(piecesSale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de peça excluido com sucesso");
	}

	public void clean() {
		piecesSale = new PiecesSale();
	}

	public PiecesSaleServiceImpl getService() {
		return service;
	}

	public void setService(PiecesSaleServiceImpl service) {
		this.service = service;
	}

	public PiecesSaleRepositoryImpl getRepositorySale() {
		return repositorySale;
	}

	public void setRepositorySale(PiecesSaleRepositoryImpl repositorySale) {
		this.repositorySale = repositorySale;
	}

	public PiecesSale getPiecesSale() {
		return piecesSale;
	}

	public void setPiecesSale(PiecesSale piecesSale) {
		this.piecesSale = piecesSale;
	}

	public List<PiecesSale> getListOfPiecesSales() {
		return listOfPiecesSales;
	}

	public void setListOfPiecesSales(List<PiecesSale> listOfPiecesSales) {
		this.listOfPiecesSales = listOfPiecesSales;
	}

}
