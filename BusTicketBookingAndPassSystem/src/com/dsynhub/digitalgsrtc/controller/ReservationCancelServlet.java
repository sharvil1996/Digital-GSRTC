package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.ReservationDAO;

public class ReservationCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationId=request.getParameter("reservationId");
	new ReservationDAO().cancelReservation(reservationId);
	request.setAttribute("msgCancel", " successfully cancelled");
	request.getRequestDispatcher("ShowReservationServlet").forward(request, response);
	
	}

}
