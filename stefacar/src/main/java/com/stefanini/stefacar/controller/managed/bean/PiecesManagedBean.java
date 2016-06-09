package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Manufacturer;
import com.stefanini.stefacar.model.domain.ModelCar;
import com.stefanini.stefacar.model.domain.Outfitter;
import com.stefanini.stefacar.model.domain.Pieces;
import com.stefanini.stefacar.model.repository.impl.ManufacturerRepository;
import com.stefanini.stefacar.model.repository.impl.ModelCarRepositoryImpl;
import com.stefanini.stefacar.model.repository.impl.OutfitterRepository;
import com.stefanini.stefacar.model.service.impl.PiecesServiceImpl;

@ManagedBean
@ViewScoped
public class PiecesManagedBean {
	private Pieces pieces;
	private List<Pieces> dataList;

	@Inject
	protected PiecesServiceImpl service;

	@Inject
	private OutfitterRepository outfitterRepository;

	@Inject
	private ManufacturerRepository manufacturerRepository;

	@Inject
	private ModelCarRepositoryImpl modelRepository;

	private List<Outfitter> listOfOutfitter;
	private List<Manufacturer> listOfManufacturer;
	private List<ModelCar> listOfmodel;

	@PostConstruct
	public void init() {
		listOfOutfitter = outfitterRepository.listAllRecords();
		listOfManufacturer = manufacturerRepository.listAllRecords();
		listOfmodel = modelRepository.listAllRecords();
		pieces = new Pieces();
		dataList = service.loadAllPiecesFromDataBase();
	}

	public void save() {
		service.save(getPieces());
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro da Peça salvo com sucesso");
		clean();
	}

	public void delete(Pieces pieces) {
		service.delete(pieces);
		dataList.remove(pieces);
		MessengerSystem.notificaInformacao("Parabens!", "Cadastro da Peça excluido com sucesso!");
	}

	public void setList(List<Pieces> dataList) {
		this.dataList = dataList;
	}

	public List<Pieces> getDataList() {
		return dataList;
	}

	public List<Outfitter> getListOfOutfitter() {
		return listOfOutfitter;
	}

	public void setListOfOutfitter(List<Outfitter> listOfOutfitter) {
		this.listOfOutfitter = listOfOutfitter;
	}

	public List<Manufacturer> getListOfManufacturer() {
		return listOfManufacturer;
	}

	public void setListOfManufacturer(List<Manufacturer> listOfManufacturer) {
		this.listOfManufacturer = listOfManufacturer;
	}

	public List<ModelCar> getListOfmodel() {
		return listOfmodel;
	}

	public void setListOfmodel(List<ModelCar> listOfmodel) {
		this.listOfmodel = listOfmodel;
	}

	public Pieces getPieces() {
		return pieces;
	}

	public void setPieces(Pieces pieces) {
		this.pieces = pieces;
	}

	public void clean() {
		setPieces(new Pieces());
	}
}
