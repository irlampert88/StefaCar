package com.stefanini.stefacar.controller.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.stefanini.stefacar.model.domain.Login;


public class ReportHelper {

	private static String gerarIdReport() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
		String id = simpleDateFormat.format(new Date());

		return id;
	}

	public static StreamedContent convertStringToStreamedContent(String pathRelatorio) {
		InputStream inputStream = null;
		try {
			File file = new File(pathRelatorio);
			inputStream = new FileInputStream(file);

			return new DefaultStreamedContent(inputStream, "application/pdf", file.getName());

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Gera relatorio retornando o caminho do PDF gerado para download
	public static String gerarRelatorio(String relatorio, List<? extends AbstractBean> beans,
			Map<String, Object> params, Login login, boolean showHeaderAndFooter) {
		try {

			String reportExportPath = FacesContext.getCurrentInstance().getExternalContext()
					.getInitParameter("reportDirectory");

			String pathRelatorio = FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("/WEB-INF/report/") + "/";

			if (params == null) {
				params = new HashMap<String, Object>();
			}

			params.put("endereco", Codigos.ENDERECO);
			params.put("razaoSocial", Codigos.RAZAO_SOCIAL);
			params.put("cidade", Codigos.CIDADE);
			params.put("estado", Codigos.ESTADO);
			params.put("cep", Codigos.CEP);
			params.put("pathLogomarca", pathRelatorio + "logo.jpg");
			params.put("pathSubreport", pathRelatorio);
			params.put("usuario", login.getLogin());
			params.put("base", login.getBase().getPessoaJuridica().getNome());
			params.put("showHeaderAndFooter", showHeaderAndFooter);

			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(beans);

			String relatorioFormated = relatorio.endsWith(".jasper") ? relatorio
					: (new StringBuilder()).append(relatorio).append(".jasper").toString();

			net.sf.jasperreports.engine.JasperPrint jasperPrint = JasperFillManager
					.fillReport(pathRelatorio + relatorioFormated, params, beanCollectionDataSource);

			String pdfFileName = reportExportPath + relatorio + "_" + gerarIdReport() + ".pdf";

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(pdfFileName));
			exporter.exportReport();

			return pdfFileName;
		} catch (JRException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}