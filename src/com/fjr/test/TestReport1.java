package com.fjr.test;

import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

public class TestReport1 {

	public TestReport1() throws JRException, FileNotFoundException {
		JRCsvDataSource ds = new JRCsvDataSource("src/com/fjr/test/excel-1.csv");
		ds.setUseFirstRowAsHeader(true);
		JasperReport report = JasperCompileManager.compileReport("src/com/fjr/test/contoh.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null , ds);
		JasperExportManager.exportReportToPdfFile(print, "D:/mm.pdf" );
	}
	
	public static void main(String[] args) {
		try {
			new TestReport1(); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
