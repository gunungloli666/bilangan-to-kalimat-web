package com.fjr.action.facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadLog extends HttpServlet{

	
	public void doGet(HttpServletRequest req , HttpServletResponse res) {
		String path = getServletContext().getRealPath("/WEB-INF/file/userlist.xml");
		try {
			readFile(path, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public synchronized void readFile(String path , HttpServletResponse resp) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		
		resp.setContentType("text/html") ;
		PrintWriter print = resp.getWriter();
		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dbuild = dbfac.newDocumentBuilder(); 
		Document doc = dbuild.parse(new FileInputStream(path)); 
		
		NodeList nodelist = doc.getElementsByTagName("log"); 
	
		for(int i = 0; i < nodelist.getLength(); i++){
		     Node n = nodelist.item(i);  
		     NamedNodeMap  nnp = n.getAttributes(); 
		     String nama = nnp.getNamedItem("nama").getNodeValue(); 
		     String pass = nnp.getNamedItem("password").getNodeValue();		    
		     print.println("nama: " + nama + "| password: " + pass + "<br />");
		}
		
		print.close();
//		System.out.println("selamat siang");
	}
}
