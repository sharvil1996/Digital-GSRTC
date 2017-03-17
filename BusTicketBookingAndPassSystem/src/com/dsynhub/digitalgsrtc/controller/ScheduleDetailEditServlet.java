package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;

public class ScheduleDetailEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String scheduleDetailId = request.getParameter("scheduleId");
		
		ScheduleDetailBean scheduleDetailBean = new ScheduleDetailDAO().getByPK(scheduleDetailId);
		
		if(scheduleDetailBean!=null)
		{
			request.setAttribute("scheduleDetailBean",scheduleDetailBean);
			request.getRequestDispatcher("scheduleDetailEdit.jsp").forward(request, response);
		}
	
	
	}

}
