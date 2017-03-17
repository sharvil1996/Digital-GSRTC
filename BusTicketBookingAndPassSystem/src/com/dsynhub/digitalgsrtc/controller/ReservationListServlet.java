package com.dsynhub.digitalgsrtc.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;


public class ReservationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<ReservationBean> listofReservationBean = new ReservationDAO().list();
		if (listofReservationBean != null) {
			request.setAttribute("listofReservation", listofReservationBean);
			request.getRequestDispatcher("reservationList.jsp").forward(request,
					response);
		} else {
			System.out.println("No Record Found....");
		}
	}

}
