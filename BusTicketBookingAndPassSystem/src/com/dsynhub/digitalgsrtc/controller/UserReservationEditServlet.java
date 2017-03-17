package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;

public class UserReservationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String reservationId = request.getParameter("reservationId");
		ReservationBean reservationBean = new ReservationDAO().getByPK(reservationId);

		HttpSession session=request.getSession();

		
		System.out.println("" + reservationBean.getSourceName());
		
		if(reservationBean!=null)
		{
			
			session.setAttribute("sourceId",reservationBean.getSourceId());
			session.setAttribute("destinationId",reservationBean.getDestinationId());
			session.setAttribute("reservationId",reservationId);
			session.setAttribute("distance",reservationBean.getDistance());
			
			session.setAttribute("userId",reservationBean.getUserId());
			
			session.setAttribute("email",reservationBean.getEmail());

			session.setAttribute("busNo",reservationBean.getBusNo());
			request.setAttribute("reservationBean",reservationBean);
			request.getRequestDispatcher("userReservationEdit.jsp").forward(request, response);
		}
	
	
	}

}
