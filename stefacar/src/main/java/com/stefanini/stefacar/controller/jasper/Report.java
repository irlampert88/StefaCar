package com.stefanini.stefacar.controller.jasper;

import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

 
public class Report 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public Report() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "/stefacar/src/main/java/com/stefanini/stefacar/controller/jasper";
		System.out.println(path);
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void print(List<?> list, String target) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + target);
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
 
		JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}