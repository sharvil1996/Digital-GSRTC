package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class UserReservationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ReservationBean reservationBean = new ReservationBean();

		String noOfSeat = request.getParameter("noOfSeat");
		String journeyDate = request.getParameter("resDate");

		String reservationId = request.getParameter("reservationId");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		ScheduleDetailBean scheduleDetailBean = (ScheduleDetailBean) session
				.getAttribute("scheduleDetailBean");

		boolean isError = false;
		if (userId.equals("0")) {
			isError = true;
			request.setAttribute("msgUserName", "please select user");
		}
		if (journeyDate.equals("")) {

			isError = true;
			request.setAttribute("msgDate", "please select journey date");

		}

		if (ValidationUtils.isEmpty(noOfSeat)) {
			isError = true;
			request.setAttribute("msgSeat", "please enter no of seat");

		}
		if (isError) {
			// reservationBean.setNoOfSeat(Integer.parseInt(noOfSeat));
			reservationBean.setUserId(userId);
			reservationBean.setReservationId(reservationId);

			reservationBean.setJourneyDate(journeyDate.replaceAll("-", "/"));
			reservationBean.setBusNo((String) session.getAttribute("busNo"));
			// session.invalidate();

			request.setAttribute("reservationBean", reservationBean);

			request.getRequestDispatcher("userReservationEdit.jsp").forward(
					request, response);
		} else {

			reservationBean.setJourneyDate(journeyDate);
			reservationBean.setBusNo((String) session.getAttribute("busNo"));

			reservationBean.setDestinationId((String) session
					.getAttribute("destinationId"));
			reservationBean.setSourceId((String) session
					.getAttribute("sourceId"));

			reservationBean.setDistance((int) session.getAttribute("distance"));
			reservationBean.setReservationId((String) session
					.getAttribute("reservationId"));
			reservationBean.setNoOfSeat(Integer.parseInt(noOfSeat));
			reservationBean.setTotalAmount((int) ((int) Integer
					.parseInt(noOfSeat) * ((int) session
					.getAttribute("distance") * 0.8)));

			reservationBean.setUserId(userId);
			session = request.getSession();
			session.setAttribute("reservationBean", reservationBean);
			request.getRequestDispatcher("userReservationDetailEdit.jsp").forward(
					request, response);

		}
	}
}
