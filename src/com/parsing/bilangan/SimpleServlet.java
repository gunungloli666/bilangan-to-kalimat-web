package com.parsing.bilangan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet{

	private BilanganToKalimat bil ;
	public SimpleServlet() {
//		System.out.println("hello"); 
		bil = new BilanganToKalimat();
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse  response) {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/input_data.jsp");
		request.setAttribute("keluaran" , "");
		request.setAttribute("masukan" , "" );
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse  response) {
		String  masukan = request.getParameter("bilanganMasukan");
		
		String keluaran = bil.hitungBilanganKeluaran(masukan);
		String output = ""; 
		if(keluaran != null) {
			output = keluaran;
		}
		String bilMasuk  = ""; 
		if(masukan!= null) {
			bilMasuk = masukan ;
		}
		request.setAttribute("keluaran" , output);
		request.setAttribute("masukan" , bilMasuk );
		
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/input_data.jsp");
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}
