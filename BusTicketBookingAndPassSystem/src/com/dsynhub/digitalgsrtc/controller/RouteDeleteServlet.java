package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.RouteDAO;


public class RouteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String routeId = request.getParameter("routeId");	
		if(new RouteDAO().checkReference(routeId))
			request.setAttribute("msgroute", " can't be  deleted[child record found]");
		else{
			if (new RouteDAO().delete(routeId)) {
				response.sendRedirect("RouteListServlet");
			} else {
				response.sendRedirect("RouteListServlet");
			}
		}

	
	}

}
