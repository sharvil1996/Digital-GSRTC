package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.BusCategoryDAO;
import com.dsynhub.digitalgsrtc.dao.OrganizationDAO;

public class OrganizationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String orgId = request.getParameter("orgId");	
		if (new OrganizationDAO().delete(orgId)) {
			response.sendRedirect("OrganizationListServlet");
		} else {
			response.sendRedirect("OrganizationListServlet");
		}


		
	}

}
