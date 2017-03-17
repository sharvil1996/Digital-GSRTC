package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.LogsBean;
import com.dsynhub.digitalgsrtc.dao.LogsDAO;

@SuppressWarnings("serial")
public class LogsListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LogsBean> listOfLogs = new LogsDAO().list();
		
		if(listOfLogs!=null)
		{
			request.setAttribute("listOfLogs",listOfLogs);
			request.getRequestDispatcher("logsList.jsp").forward(request, response);
		}
	}

}
