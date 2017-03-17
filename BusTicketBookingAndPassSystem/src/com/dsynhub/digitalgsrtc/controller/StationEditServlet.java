package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.StationBean;
import com.dsynhub.digitalgsrtc.dao.StationDAO;


public class StationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String stationId = request.getParameter("stationId");
		
		StationBean stationBean = new StationDAO().getByPK(stationId);
		if(stationBean!=null){
				request.setAttribute("stationBean", stationBean);
				request.getRequestDispatcher("stationEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("StationListServlet");
		}

		
	}

}
