package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;

public class ScheduleSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String scheduleId=request.getParameter("scheduleId");
		
		ScheduleDetailBean scheduleDetailBean=new ScheduleDetailDAO().getByPK(scheduleId);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("scheduleDetailBean", scheduleDetailBean);
		
		
			response.sendRedirect("reservationInsert.jsp");
			
		
		
	}
}

