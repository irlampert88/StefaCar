package com.stefanini.stefacar.controller.managed.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.converter.MessengerSystem;
import com.stefanini.stefacar.model.domain.Client;
import com.stefanini.stefacar.model.domain.Employee;
import com.stefanini.stefacar.model.domain.Pieces;
import com.stefanini.stefacar.model.domain.PiecesSale;
import com.stefanini.stefacar.model.repository.impl.ClientRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.EmployeeRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.PiecesRepositoryImpl;
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

	@Inject
	private EmployeeRepositoryImpl repositoryEmployee;

	@Inject
	private PiecesRepositoryImpl repositoryCar;

	@Inject
	private ClientRepositoryImpl repositoryClient;

	private PiecesSale piecesSale;
	private List<PiecesSale> listOfPiecesSales;
	private List<Employee> listOfEmployee;
	private List<Pieces> listOfPieces;
	private List<Client> listOfClient;

	@PostConstruct
	public void init() {
		piecesSale = new PiecesSale();
		listOfPiecesSales = repositorySale.listAllRecords();
		listOfEmployee = repositoryEmployee.listAllRecords();
		listOfPieces = repositoryCar.listAllRecords();
		listOfClient = repositoryClient.listAllRecords();
	}

	public void save() {
		service.save(piecesSale);
		MessengerSystem.notificaInformacao("Parabéns!", "Cadastro de Venda de peça salvo com sucesso");
		clean();
	}

	public void delete(PiecesSale piecesSale) {
		service.delete(piecesSale);
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

	public EmployeeRepositoryImpl getRepositoryEmployee() {
		return repositoryEmployee;
	}

	public void setRepositoryEmployee(EmployeeRepositoryImpl repositoryEmployee) {
		this.repositoryEmployee = repositoryEmployee;
	}

	public PiecesRepositoryImpl getRepositoryCar() {
		return repositoryCar;
	}

	public void setRepositoryCar(PiecesRepositoryImpl repositoryCar) {
		this.repositoryCar = repositoryCar;
	}

	public ClientRepositoryImpl getRepositoryClient() {
		return repositoryClient;
	}

	public void setRepositoryClient(ClientRepositoryImpl repositoryClient) {
		this.repositoryClient = repositoryClient;
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

	public List<Employee> getListOfEmployee() {
		return listOfEmployee;
	}

	public void setListOfEmployee(List<Employee> listOfEmployee) {
		this.listOfEmployee = listOfEmployee;
	}

	public List<Pieces> getListOfPieces() {
		return listOfPieces;
	}

	public void setListOfPieces(List<Pieces> listOfPieces) {
		this.listOfPieces = listOfPieces;
	}

	public List<Client> getListOfClient() {
		return listOfClient;
	}

	public void setListOfClient(List<Client> listOfClient) {
		this.listOfClient = listOfClient;
	}
}
