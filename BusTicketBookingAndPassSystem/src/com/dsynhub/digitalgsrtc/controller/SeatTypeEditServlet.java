package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.SeatTypeBean;
import com.dsynhub.digitalgsrtc.dao.SeatTypeDAO;


public class SeatTypeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String seatTypeId = request.getParameter("seatTypeId");
		
		SeatTypeBean seatTypeBean = new SeatTypeDAO().getByPK(seatTypeId);
		if(seatTypeBean!=null){
				request.setAttribute("seatTypeBean", seatTypeBean);
				request.getRequestDispatcher("seatTypeEdit.jsp").forward(request, response);
		}else{
				response.sendRedirect("SeatTypeListServlet");
		}

		
	}

}
