package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.dao.StationDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class StationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String stationName = request.getParameter("txtStationName");
		String cityId = request.getParameter("selCityName");
		
		boolean isError=false;
		StationBean stationBean = new StationBean();
		
		if(ValidationUtils.isEmpty(stationName))
		{
			request.setAttribute("stationName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtStationName", stationName);
			if(stationName == null)
				stationName="";
			stationBean.setStationName(stationName);
		}
		if (cityId.equals("0")) 
		{
			isError = true;
			request.setAttribute("msgCityName",
					"<font color=red>* CITY is Required</font>");
		} 
		
		if(isError)
		{
			System.out.println("error");
			request.getRequestDispatcher("stationInsert.jsp").forward(request, response);
		}else{
			System.out.println("success");	
			stationBean.setCityId(cityId);
			if(new StationDAO().insert(stationBean)) {
				response.sendRedirect("StationListServlet");
			}else{
				response.sendRedirect("StationInsert.jsp");
			}
		}

	
	}

}
