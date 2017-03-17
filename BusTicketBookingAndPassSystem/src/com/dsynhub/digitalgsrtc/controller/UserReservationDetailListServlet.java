package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;
import com.dsynhub.digitalgsrtc.dao.ReservationDetailDAO;

public class UserReservationDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reservationId=request.getParameter("reservationId");
		ArrayList<ReservationDetailBean> listOfReservationDetailBeans=
				new ReservationDetailDAO().getReservationDetailListByPK(reservationId);
		
		if(listOfReservationDetailBeans != null)
		{
			request.setAttribute("reservationBean", new ReservationDAO().getByPK(reservationId));
			request.setAttribute("listOfReservationDetailBeans", listOfReservationDetailBeans);
			request.getRequestDispatcher("userReservationDetailList.jsp").forward(request, response);
		}
	}

}
