package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.ReservationBean;
import com.dsynhub.digitalgsrtc.bean.ReservationDetailBean;
import com.dsynhub.digitalgsrtc.dao.ReservationDAO;
import com.dsynhub.digitalgsrtc.dao.ReservationDetailDAO;

public class ReservationDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String reservationId=request.getParameter("reservationId");
		
		System.out.println("id" + reservationId);
		
		ArrayList<ReservationDetailBean> listOfReservationDetailBeans=
				new ReservationDetailDAO().getReservationDetailListByPK(reservationId);
		
		ReservationBean reservationBean= new ReservationDAO().getByPK(reservationId);
		
		if(listOfReservationDetailBeans != null)
		{
			request.setAttribute("reservationBean", reservationBean);
			request.setAttribute("listofReservationDetails", listOfReservationDetailBeans);
			request.getRequestDispatcher("reservationDetailList.jsp").forward(request, response);
		}
		else{
			System.out.println("No Record Found....");
		}
	}

}
