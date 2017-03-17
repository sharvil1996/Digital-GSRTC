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


public class ScheduleDetailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String routeId=request.getParameter("selRouteName");
		String sourceId=request.getParameter("sourceName");
		String destinationId=request.getParameter("destinationName");
		String weekOffDay=request.getParameter("weekOffDay");
		String offDate=request.getParameter("txtWeekOffDate");
		String reachTime=request.getParameter("txtReachTime");
		String departureTime=request.getParameter("txtDepartureTime");
		String arrivalTime=request.getParameter("txtArrivalTime");	
		String busNo=request.getParameter("selBusNo");
		String distance=request.getParameter("txtDistance");
		
		ScheduleDetailBean scheduleDetailBean = new ScheduleDetailBean();
		 
		
		boolean isError=false;
		if(ValidationUtils.isEmpty(distance))
		{
			request.setAttribute("msgDistance", "please enter distance");
			isError=true;
		}
		else
		{
			request.setAttribute("txtDistance", distance);
			scheduleDetailBean.setDistance(Integer.parseInt(distance));
		}
		
		
		if(routeId.equals("0"))
		{
			request.setAttribute("msgRouteName", "please select route");
			isError=true;
		}
		else
		{
			request.setAttribute("routeName", routeId);
		}
		if(weekOffDay.equals("0"))
		{
			request.setAttribute("msgWeekOffDay", "please select Week Of Day");
			isError=true;
		}
		else
		{
			request.setAttribute("weekOffDay", weekOffDay);
		}
		
		if(busNo.equals("0"))
		{
			request.setAttribute("msgBusNo", "please select bus no");
			isError=true;
		}
		else
		{
			request.setAttribute("busNo",busNo);
		}
		
		if(sourceId=="")
		{	
			request.setAttribute("msgSourceName", "please enter source");
			isError=true;				
		}
		else
		{
			request.setAttribute("sourceName", sourceId);	
		}
		
		if(offDate=="")
		{	
			request.setAttribute("msgweekOffDate", "please enter Week of  Day");
			isError=true;				
		}
		else
		{
			request.setAttribute("weekOffDate", offDate);	
		}
		
		if(destinationId=="")
		{
			request.setAttribute("msgDestinationName", "please enter destination");
			isError=true;

		}
		else
		{
			request.setAttribute("destinationName", destinationId);	
		}
		if(reachTime=="")
		{
			request.setAttribute("msgReachTime", "please select reach time");
			isError=true;
		}
		else
		{
			request.setAttribute("reachTime", reachTime);	
		}
		if(departureTime=="")
		{
			request.setAttribute("msgDepartureTime", "please select departure time");
			isError=true;
		}
		else
		{
			request.setAttribute("departureTime", departureTime);	
		}
		if(arrivalTime=="")
		{
			request.setAttribute("msgArrivalTime", "please select arrival time");
			isError=true;
		}
		else
		{
			request.setAttribute("arrivalTime", arrivalTime);	
		}
		
		if(isError)
		{
			request.getRequestDispatcher("schuduleDetailInsert.jsp").forward(request, response);
		}
		else
		{
		
		
			scheduleDetailBean.setArrivalTime(arrivalTime);
			scheduleDetailBean.setDepartureTime(departureTime);
			scheduleDetailBean.setDestinationId (new ScheduleDetailDAO().getStationId(destinationId));
			scheduleDetailBean.setSourceId(new ScheduleDetailDAO().getStationId(sourceId));
			scheduleDetailBean.setOffDate(offDate);
			scheduleDetailBean.setWeekOfDay(Integer.parseInt(weekOffDay));
			//scheduleDetailBean.setScheduleDetailId("2");
			scheduleDetailBean.setDistance(Integer.parseInt(distance));
			scheduleDetailBean.setReachTime(reachTime);
			scheduleDetailBean.setBusDetailId(new BusDetailDAO().getBusDetailId(busNo,routeId));

			if(new ScheduleDetailDAO().insert(scheduleDetailBean))
			{
				request.setAttribute("msgSchedule", "sucessfully added");
				request.getRequestDispatcher("ScheduleDetailListServlet").forward(request, response);
			}
			else
			{	
				request.setAttribute("msgSchedule", "failed to add");
				request.getRequestDispatcher("scheduleDetailInsert.jsp").forward(request, response);
			}
			
		}

	}

}

