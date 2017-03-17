package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.RouteBean;
import com.dsynhub.digitalgsrtc.dao.RouteDAO;


public class RouteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String routeId = request.getParameter("routeId");
		
		RouteBean routeBean = new RouteDAO().getByPK(routeId);
		if(routeBean!=null){
				request.setAttribute("routeBean", routeBean);
				request.getRequestDispatcher("routeEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("RouteListServlet");
		}

		
	}

}
