package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.dao.StationDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class StationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String stationName = request.getParameter("txtStationName");
		String stationId = request.getParameter("stationId");
		String cityId = request.getParameter("selCityName");
		boolean isError=false;
		
		
		StationBean stationbean = new StationBean();
		
		if(ValidationUtils.isEmpty(stationName))
		{
			request.setAttribute("stationName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtStationName", stationName);
			if(stationName == null)
				stationName="";
			stationbean.setStationName(stationName);
		}
		
		if (cityId.equals("0")) 
		{
			
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 
		
		if(isError)
		{
			stationbean.setCityId(cityId);
			stationbean.setStationId(stationId);
			stationbean.setStationName(stationName);
			request.setAttribute("stationBean",stationbean);
			request.getRequestDispatcher("stationEdit.jsp").forward(request, response);
		}else{
			stationbean.setStationId(stationId);
			stationbean.setCityId(cityId);
			if(new StationDAO().update(stationbean))
			{
				response.sendRedirect("StationListServlet");
			}
			else
			{
				response.sendRedirect("stationEdit.jsp");
			}
		}

		
	}

}
