package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class ReservationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		String noOfSeat = request.getParameter("noOfSeat");
		String journeyDate = request.getParameter("resDate");
		String userId = request.getParameter("selUser");
		
		
		boolean isError = false;
		if (userId.equals("0")) {
			isError = true;
			request.setAttribute("msgUser", "please select user");
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
			request.getRequestDispatcher("reservationInsert.jsp").forward(
					request, response);
		} else {
			HttpSession session = request.getSession();
			ScheduleDetailBean scheduleDetailBean = (ScheduleDetailBean) session
					.getAttribute("scheduleDetailBean");
			ReservationBean reservationBean = new ReservationBean();
			reservationBean.setJourneyDate(journeyDate);
			reservationBean.setBusNo(scheduleDetailBean.getBusNo());
			reservationBean.setDestinationId(scheduleDetailBean
					.getSourceId());
			reservationBean.setSourceId(scheduleDetailBean
					.getDestinationId());
			reservationBean.setDistance(scheduleDetailBean.getDistance());
			reservationBean.setNoOfSeat(Integer.parseInt(noOfSeat));
			reservationBean.setTotalAmount((int) ((int) reservationBean
					.getNoOfSeat() * (scheduleDetailBean.getDistance() * 0.8)));
			reservationBean.setUserId(userId);
			session = request.getSession();
			session.setAttribute("reservationBean", reservationBean);
			request.getRequestDispatcher("reservationDetailInsert.jsp")
					.forward(request, response);

		}
	}

}
