package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.bean.OrganizationBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;
import com.dsynhub.digitalgsrtc.dao.OrganizationDAO;

public class BusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<BusBean> listofBus = new BusDAO().list();
		if (listofBus != null) {
			request.setAttribute("listofBus", listofBus);
			request.getRequestDispatcher("busList.jsp").forward(request,
					response);
		} else {
			System.out.println("No Record Found....");
		}
	}

}
