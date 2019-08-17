package com.fjr.helloworld;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeHome extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/input_data.jsp");
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
		
		
	}

}
