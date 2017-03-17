package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.RouteBean;
import com.dsynhub.digitalgsrtc.dao.RouteDAO;


public class RouteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<RouteBean> listofRoute = new RouteDAO().list();
		if(listofRoute != null)
		{
			request.setAttribute("listofRoute",listofRoute);
			request.getRequestDispatcher("routeList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}

		
	}

}
