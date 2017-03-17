package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.dao.RouteDAO;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;

public class ScheduleDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String scheduleId = request.getParameter("scheduleId");
		if (new ScheduleDetailDAO().delete(scheduleId)) {
			
			response.sendRedirect("ScheduleDetailListServlet");
		} else {
			response.sendRedirect("ScheduleDetailListServlet");
		}

	}

}
