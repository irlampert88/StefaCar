package com.stefanini.stefacar.controller.managed.bean;

import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class ReportManagedBean {
	private StreamedContent file;

	public ReportManagedBean() {
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext()
				.getResourceAsStream("C:/Users/pvmeira/Desktop/Relatorios/relatorioDeCliente.pdf");
		file = new DefaultStreamedContent(stream, "application/pdf", "relatorioDeCliente.pdf");
	}

	public StreamedContent getFile() {
		return file;
	}
}
