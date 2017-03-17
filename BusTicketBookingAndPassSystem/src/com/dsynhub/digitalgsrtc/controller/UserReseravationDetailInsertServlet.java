package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;


public class UserReseravationDetailInsertServlet extends HttpServlet {
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
					"please select only " + rb.getNoOfSeat() + " only");
			request.getRequestDispatcher("userReservationDetailInsert.jsp")
					.forward(request, response);
		} else {
			
			session.setAttribute("reservationDetailBean",reservationDetailBean);
			request.setAttribute("msgResDet", "successfully a added");
			request.getRequestDispatcher("userReservationList.jsp").forward(
					request, response);
		}
	}

}
