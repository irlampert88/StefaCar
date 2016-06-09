package com.stefanini.stefacar.controller.managed.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.stefanini.stefacar.controller.shared.MessengerSystem;
import com.stefanini.stefacar.model.domain.Pieces;
import com.stefanini.stefacar.model.service.impl.PiecesServiceImpl;

@ManagedBean
@SessionScoped
public class PiecesManagedBean {
	private Pieces pieces;
	private List<Pieces> dataList;

	@Inject
	protected PiecesServiceImpl service;

	@PostConstruct
	public void init() {

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

	public Pieces getPieces() {
		return pieces;
	}

	public void setPieces(Pieces pieces) {
		this.pieces = pieces;
	}

	public void setPiecesForEdit(Pieces pieces) {
		this.pieces = pieces;
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("piecesRegister.xhtml");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void clean() {
		setPieces(new Pieces());
		dataList = service.loadAllPiecesFromDataBase();
	}
}
