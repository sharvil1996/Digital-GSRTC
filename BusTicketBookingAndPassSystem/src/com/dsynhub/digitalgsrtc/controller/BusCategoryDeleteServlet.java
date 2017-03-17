package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.BusCategoryDAO;


public class BusCategoryDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String busCategoryId = request.getParameter("busCategoryId");	
		if (new BusCategoryDAO().delete(busCategoryId)) {
			response.sendRedirect("BusCategoryListServlet");
		} else {
			response.sendRedirect("BusCategoryListServlet");
		}

	
	}

}
