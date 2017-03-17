package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.CityBean;
import com.dsynhub.digitalgsrtc.dao.CityDAO;


public class CityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CityBean> listOfCity = new CityDAO().list();
		
		if(listOfCity!=null)
		{
			request.setAttribute("listOfCity",listOfCity);
			request.getRequestDispatcher("cityList.jsp").forward(request, response);
		}
	}

}
