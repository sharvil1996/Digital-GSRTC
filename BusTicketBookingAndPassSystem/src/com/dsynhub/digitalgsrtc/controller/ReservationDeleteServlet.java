package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;
import com.dsynhub.digitalgsrtc.dao.ReservationDetailDAO;

public class ReservationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		String reservationId = request.getParameter("reservationId");

		if (new ReservationDetailDAO().delete(reservationId)) {
			response.sendRedirect("ReservationListServlet");

		} else {
			response.sendRedirect("ReservationListServlet");

		}
	}

}

	
	
	
	
