package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.SeatTypeBean;
import com.dsynhub.digitalgsrtc.dao.SeatTypeDAO;
import com.dsynhub.digitalgsrtc.util.ValidationUtils;


public class SeatTypeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String seatTypeName = request.getParameter("txtSeatTypeName");
		
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
			System.out.println("error");
			request.getRequestDispatcher("seatTypeInsert.jsp").forward(request, response);
		}else{
			System.out.println("success");	
			if(new SeatTypeDAO().insert(seatTypebean)) {
				response.sendRedirect("SeatTypeListServlet");
			}else{
				response.sendRedirect("seatTypeInsert.jsp");
			}
		}

	
	}

}
