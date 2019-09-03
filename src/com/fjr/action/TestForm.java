package com.fjr.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestForm extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getSession().getId();
		request.setAttribute("id", id);
		
		try {
			request.getRequestDispatcher("/WEB-INF/test/test.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String nama = ""; 
		nama = request.getParameter("nama"); 
		String id = request.getSession().getId();
		request.setAttribute("id", id);
//		System.out.println(nama); 
		request.setAttribute("nama", nama);
		try {
			request.getRequestDispatcher("/WEB-INF/test/test.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
