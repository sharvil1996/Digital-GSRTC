package com.dsynhub.digitalgsrtc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dsynhub.digitalgsrtc.bean.BusTypeBean;
import com.dsynhub.digitalgsrtc.dao.BusTypeDAO;


public class BusTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<BusTypeBean> listofBusType = new BusTypeDAO().list();
		if(listofBusType != null)
		{
			System.out.println("Hello");
			request.setAttribute("listofBusType",listofBusType);
			request.getRequestDispatcher("busTypeList.jsp").forward
			(request, response);
		}else{
			System.out.println("No Record Found....");
		}

		
	}

}
