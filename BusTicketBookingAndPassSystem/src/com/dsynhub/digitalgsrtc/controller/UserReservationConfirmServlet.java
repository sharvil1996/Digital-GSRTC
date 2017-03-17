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

public class UserReservationConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		ReservationBean rb = (ReservationBean) session.getAttribute("reservationBean");
		ReservationDetailBean reservationDetailBean = (ReservationDetailBean) session.getAttribute("reservationDetailBean");
		
		/*session.removeAttribute("reservationBean");
		session.removeAttribute("reservationDetailBean");
		*/
		request.setAttribute("reservationBean", rb);
		
		request.setAttribute("reservationDetailBean", reservationDetailBean);
		if (new ReservationDetailDAO().insert(
				reservationDetailBean, rb)) {
			request.setAttribute("msgReservation", "successfully booked");
			request.getRequestDispatcher("userReservationPrint.jsp").forward(
					request, response);

		}
	}
}
