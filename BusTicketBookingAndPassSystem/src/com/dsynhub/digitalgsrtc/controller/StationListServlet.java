package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.dao.StationDAO;


public class StationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<StationBean> listofStation = new StationDAO().list();
		if(listofStation != null)
		{
			request.setAttribute("listofStation",listofStation);
			request.getRequestDispatcher("stationList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}

		
	}

}
