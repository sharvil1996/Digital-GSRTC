package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.PassDAO;

@SuppressWarnings("serial")
public class PassDeleteServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String passId = request.getParameter("passId");	
		if (new PassDAO().delete(passId)) {
			response.sendRedirect("PassListServlet");
		} else {
			response.sendRedirect("PassListServlet");
		}
	}

}
