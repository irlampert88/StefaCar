package com.stefanini.stefacar.controller.managed.bean;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.stefacar.controller.jasper.Report;
import com.stefanini.stefacar.model.domain.Client;

public class ReportManagedBean {
	@Inject
	private Report report;

	public void generateClienteReport(List<Client> client) {
		String target="ClientReport.jrxml";
		try {
			report.print(client,target);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
