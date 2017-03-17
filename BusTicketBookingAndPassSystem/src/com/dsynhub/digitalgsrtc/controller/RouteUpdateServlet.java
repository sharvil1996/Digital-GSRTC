package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.RouteBean;
import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.dao.RouteDAO;
import com.dsynhub.digitalgsrtc.dao.StationDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class RouteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String routeId = request.getParameter("routeId");
		String sourceId = request.getParameter("selSourceName");
		String destinationId = request.getParameter("selDestinationName");
		
		boolean isError=false;
		RouteBean routeBean = new RouteBean();
		
		
		if (sourceId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgSourceName",
					"<font color=red>* source is Required</font>");
		}
		if (destinationId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgDestinationName",
					"<font color=red>* destination is Required</font>");
		}
		if (destinationId.equals(sourceId)) 
		{
			isError = true;
			request.setAttribute("msgDestinationName",
					"<font color=red>* source & destination can't same</font>");
		}else{
			if(new RouteDAO().isExists(sourceId, destinationId))
			{
				isError = true;
				request.setAttribute("msgDestinationName",
						"<font color=red>* this route already exists</font>");
			}
		}
		if(isError )
		{
			System.out.println("error");
			routeBean.setRouteId(routeId);
			request.getRequestDispatcher("routeEdit.jsp").forward(request, response);
		}else{
			System.out.println("success");	
			routeBean.setSourceId(sourceId);
			routeBean.setRouteId(routeId);
			routeBean.setDestinationId(destinationId);
			if(new RouteDAO().update(routeBean)) {
				response.sendRedirect("RouteListServlet");
			}else{
				response.sendRedirect("routeEdit.jsp");
			}
		}

	
	}

}
