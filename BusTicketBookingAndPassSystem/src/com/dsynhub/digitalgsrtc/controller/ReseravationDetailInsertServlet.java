package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDetailDAO;

public class ReseravationDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	
		String[] seats = request.getParameter("seatId").split(",");
		HttpSession session = request.getSession();
		
		ReservationBean rb = (ReservationBean) session.getAttribute("reservationBean");
		
		ReservationDetailBean reservationDetailBean = new ReservationDetailBean();
		reservationDetailBean.setSeatNo(seats);
		reservationDetailBean.setSeatTypeId("1");
		
		if (seats.length != rb.getNoOfSeat()) {
			request.setAttribute("msgResDet",
					"Please select " + rb.getNoOfSeat() + " Seats only");
			request.getRequestDispatcher("reservationDetailInsert.jsp")
					.forward(request, response);
		} else {
			if (new ReservationDetailDAO().insert(
					reservationDetailBean, rb)) {
				request.setAttribute("msgResDet", "successfully a added");
				request.getRequestDispatcher("ReservationListServlet").forward(
						request, response);
			}

			else {
				request.setAttribute("msgResDet", "failed to add");
				request.getRequestDispatcher("reservationDetailInsert.jsp")
						.forward(request, response);

			}
			session.removeAttribute("reservatioBean");
		}

	}
}			