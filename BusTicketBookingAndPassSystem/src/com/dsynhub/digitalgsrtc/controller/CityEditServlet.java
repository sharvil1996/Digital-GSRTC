package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.CityBean;
import com.dsynhub.digitalgsrtc.dao.CityDAO;


public class CityEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cityId = request.getParameter("cid");
		
		CityBean cityBean = new CityDAO().getByPK(cityId);
		
		
		if(cityBean!=null)
		{
			request.setAttribute("cityBean",cityBean);
			request.getRequestDispatcher("cityEdit.jsp").forward(request, response);
		}
	}

}
