package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ScheduleDetailBean;
import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;
import com.dsynhub.digitalgsrtc.dao.ScheduleDetailDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;

public class ScheduleDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String sourceId=request.getParameter("selSourceName");
		String destinationId=request.getParameter("selDestinationName");
		String weekOffDay=request.getParameter("weekOffDay");
		String offDate=request.getParameter("txtWeekOffDate");
		String reachTime=request.getParameter("txtReachTime");
		String departureTime=request.getParameter("txtDepartureTime");
		String arrivalTime=request.getParameter("txtArrivalTime");	
		String busNo=request.getParameter("selBusNo");
		
		String scheduleId=request.getParameter("scheduleId");

		
		ScheduleDetailBean scheduleDetailBean = new ScheduleDetailBean();
		 
		
		boolean isError=false;
		
		
		if(weekOffDay.equals("0"))
		{
			request.setAttribute("msgWeekOffDay", "please select Week Of Day");
			isError=true;
		}
		else
		{
			scheduleDetailBean.setWeekOfDay(Integer.parseInt(weekOffDay));
			request.setAttribute("weekOffDay", weekOffDay);
		}
		
		if(busNo.equals("0"))
		{
			request.setAttribute("msgBusNo", "please select bus no");
			isError=true;
		}
		else
		{
			scheduleDetailBean.setBusNo(busNo);
			request.setAttribute("busNo",busNo);
		}
		
		if(sourceId=="")
		{	
			request.setAttribute("msgSourceName", "please enter source");
			isError=true;				
		}
		else
		{
			scheduleDetailBean.setSourceId(new ScheduleDetailDAO().getStationId(sourceId));
			request.setAttribute("sourceName", sourceId);	
		}
		
		if(offDate=="")
		{	
			request.setAttribute("msgweekOffDate", "please enter Week of  Day");
			isError=true;				
		}
		else
		{
			scheduleDetailBean.setOffDate(offDate);	
			request.setAttribute("weekOffDate", offDate);	
		}
		
		if(destinationId=="")
		{
			request.setAttribute("msgDestinationName", "please enter destination");
			isError=true;

		}
		else
		{
			scheduleDetailBean.setDestinationId (new ScheduleDetailDAO().getStationId(destinationId));
			request.setAttribute("destinationName", destinationId);	
		}
		if(reachTime=="")
		{
			request.setAttribute("msgReachTime", "please select reach time");
			isError=true;
		}
		else
		{
			scheduleDetailBean.setReachTime(reachTime);
			request.setAttribute("reachTime", reachTime);	
		}
		if(departureTime=="")
		{
			request.setAttribute("msgDepartureTime", "please select departure time");
			isError=true;
		}
		else
		{
			scheduleDetailBean.setDepartureTime(departureTime);
			request.setAttribute("departureTime", departureTime);	
		}
		if(arrivalTime=="")
		{
			request.setAttribute("msgArrivalTime", "please select arrival time");
			isError=true;
		}
		else
		{
			scheduleDetailBean.setArrivalTime(arrivalTime);
			request.setAttribute("arrivalTime", arrivalTime);	
		}
		
		
		
		
		
		
		
		
		scheduleDetailBean.setDistance(20);
		scheduleDetailBean.setScheduleId(scheduleId);
		
		
		if(isError)
		{
				System.out.println("Hiiiiiiiiiiii");
				scheduleDetailBean.setScheduleId(scheduleId);
				request.setAttribute("scheduleDetailBean",scheduleDetailBean);
			request.getRequestDispatcher("scheduleDetailEdit.jsp").forward(request, response);
		}
		else
		{
			if(new ScheduleDetailDAO().update(scheduleDetailBean))
			{
				request.setAttribute("msgschedule", "sucessfully updated");
				request.getRequestDispatcher("ScheduleDetailListServlet").forward(request, response);
			}
			else
			{
				request.setAttribute("scheduleDetailBean",scheduleDetailBean);
				request.setAttribute("msgschedule", "failed to update");
				request.getRequestDispatcher("scheduleDetailEdit.jsp").forward(request, response);
			}


		}

	}

}
