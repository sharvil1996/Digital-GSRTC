package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;

public class ShowReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBean userBean = (UserBean) session.getAttribute("userBean");

		if (userBean != null) {
			ArrayList<ReservationBean> reservationBeans = new ReservationDAO()
					.getUserReservationList(userBean.getUserId());

			session.setAttribute("reservationBean", reservationBeans);
			request.getRequestDispatcher("showUserReservation.jsp").forward(
					request, response);
		}
	}

}
