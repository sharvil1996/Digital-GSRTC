package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.Validate;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.bean.UserBean;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class UserReservationInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String noOfSeat=request.getParameter("noOfSeat");
		String journeyDate=request.getParameter("resDate");
		
		boolean isError=false;
		
		if(journeyDate.equals(""))
		{
			isError=true;
			request.setAttribute("msgDate", "please select journey date");
			
		}

		if(ValidationUtils.isEmpty(noOfSeat))
		{
			isError=true;
			request.setAttribute("msgSeat", "please enter no of seat");
			
		}
		if(isError)
		{
			request.getRequestDispatcher("userReservationInsert.jsp").forward(request, response);
		}
		else
		{
			HttpSession session=request.getSession();
			UserBean userBean=(UserBean)session.getAttribute("userBean");
			
			ScheduleDetailBean scheduleDetailBean= (ScheduleDetailBean)session.getAttribute("scheduleDetailBean");
			
			ReservationBean reservationBean=new  ReservationBean();

			reservationBean.setJourneyDate(journeyDate);
			reservationBean.setBusNo(scheduleDetailBean.getBusNo());
			reservationBean.setDestinationId(scheduleDetailBean.getDestinationId());
			reservationBean.setSourceId(scheduleDetailBean.getSourceId());
			reservationBean.setDistance(scheduleDetailBean.getDistance());
			reservationBean.setNoOfSeat(Integer.parseInt(noOfSeat));
			reservationBean.setTotalAmount((int) ((int)reservationBean.getNoOfSeat()*(scheduleDetailBean.getDistance()*0.8)));
			reservationBean.setUserId(userBean.getUserId());
			
			session.setAttribute("reservationBean",reservationBean);
			
			request.getRequestDispatcher("userReservationDetailInsert.jsp").forward(request, response);
		}

	}

}
