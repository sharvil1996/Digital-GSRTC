package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.SeatTypeBean;
import com.dsynhub.digitalgsrtc.dao.SeatTypeDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class SeatTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		String seatTypeName = request.getParameter("txtSeatTypeName");
		String seatTypeId = request.getParameter("seatTypeId");
		boolean isError=false;
		
		
		SeatTypeBean seatTypebean = new SeatTypeBean();
		
		if(ValidationUtils.isEmpty(seatTypeName))
		{
			request.setAttribute("seatTypeName", "<font color=red>* Name is Required</font>");
			isError=true;
		}else{
			request.setAttribute("txtSeatTypeName", seatTypeName);
			if(seatTypeName == null)
				seatTypeName="";
			seatTypebean.setSeatTypeName(seatTypeName);
		}
		
		if(isError)
		{
			seatTypebean.setSeatTypeId(seatTypeId);
			seatTypebean.setSeatTypeName(seatTypeName);
			request.setAttribute("seatTypeBean",seatTypebean);
			request.getRequestDispatcher("seatTypeEdit.jsp").forward(request, response);
		}else{
			seatTypebean.setSeatTypeId(seatTypeId);
			
			if(new SeatTypeDAO().update(seatTypebean))
			{
				response.sendRedirect("SeatTypeListServlet");
			}
			else
			{
				response.sendRedirect("seatTypeEdit.jsp");
			}
		}

		
	}

}
