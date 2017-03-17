package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationStatusBean;
import com.dsynhub.digitalgsrtc.dao.ReservationStatusDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class ReservationStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String reservationStatusName = request.getParameter("txtReservationStatusName");
		String reservationStatusId = request.getParameter("reservationStatusId");
		boolean isError=false;
		
		
		ReservationStatusBean reservationStatusbean = new ReservationStatusBean();
		
		if(ValidationUtils.isEmpty(reservationStatusName))
		{
			request.setAttribute("reservationStatusName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtReservationStatusName", reservationStatusName);
			if(reservationStatusName == null)
				reservationStatusName="";
			reservationStatusbean.setReservationStatusName(reservationStatusName);
		}
		
		if(isError)
		{
			reservationStatusbean.setReservationStatusId(reservationStatusId);
			reservationStatusbean.setReservationStatusName(reservationStatusName);
			request.setAttribute("reservationStatusBean",reservationStatusbean);
			request.getRequestDispatcher("reservationStatusEdit.jsp").forward(request, response);
		}else{
			reservationStatusbean.setReservationStatusId(reservationStatusId);
			
			if(new ReservationStatusDAO().update(reservationStatusbean))
			{
				response.sendRedirect("ReservationStatusListServlet");
			}
			else
			{
				response.sendRedirect("reservationStatusEdit.jsp");
			}
		}

		
	}

}
