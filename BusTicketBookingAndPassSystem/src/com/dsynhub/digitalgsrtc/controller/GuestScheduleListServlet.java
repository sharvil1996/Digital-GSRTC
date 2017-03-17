package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;

public class GuestScheduleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
   		String sourceName=request.getParameter("selSourceName");
		String destinationName=request.getParameter("selDestinationName");
		boolean isError=false;
		if(sourceName=="")
		{
			request.setAttribute("msgSourceName","enter source");
			isError=true;
		}
		else
		{
			request.setAttribute("sourceName",sourceName);
		}
		if(destinationName=="")
		{
			request.setAttribute("msgDestinationName","enter destination");
			isError=true;
		}
		else
		{
			request.setAttribute("destioantionName",destinationName);
		}
		if(isError)
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
				String sourceId=new ScheduleDetailDAO().getStationId(sourceName);
				String destinationId=new ScheduleDetailDAO().getStationId(destinationName); 
				ArrayList<ScheduleDetailBean> scheduleDetailBeans=new ScheduleDetailDAO().
						getUserScheduleDetailList(sourceId, destinationId);
				request.setAttribute("scheduleDetailBeans",scheduleDetailBeans);
				request.getRequestDispatcher("GuestScheduleList.jsp").forward(request, response);
		}
   		
	}

}
