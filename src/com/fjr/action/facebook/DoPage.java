package com.fjr.action.facebook;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoPage extends	 HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/WEB-INF/test1/test-1.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
}
