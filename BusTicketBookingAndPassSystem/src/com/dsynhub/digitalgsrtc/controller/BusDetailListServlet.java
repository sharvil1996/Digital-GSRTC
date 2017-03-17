package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusBean;
import com.dsynhub.digitalgsrtc.bean.BusDetailBean;
import com.dsynhub.digitalgsrtc.dao.BusDAO;
import com.dsynhub.digitalgsrtc.dao.BusDetailDAO;

@SuppressWarnings("serial")
public class BusDetailListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BusDetailBean> listofBusDetail = new BusDetailDAO().list();
		if(listofBusDetail != null)
		{
			request.setAttribute("listofBusDetail",listofBusDetail);
			request.getRequestDispatcher("busDetailList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}
	}

}
